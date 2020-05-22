// Removes whitespace (if in not null), otherwise returns "".
private static String safeTrim(String in) {
  if (in != null) {
    return in.trim();
  }
  return "";
}

public static class Info {
  private String firstName;
  private String lastName;
  private String birthDay;

  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = safeTrim(firstName);
  }

  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = safeTrim(lastName);
  }

  public String getBirthDay() {
    return birthDay;
  }

  public void setBirthDay(String birthDay) {
    this.birthDay = safeTrim(birthDay);
  }

  public Info(String firstName, String lastName,
      String birthDay) {
    setFirstName(firstName);
    setLastName(lastName);
    setBirthDay(birthDay);
  }

  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("First Name: ").append(firstName)
        .append('\n');
    sb.append("Last Name: ").append(lastName)
        .append('\n');
    sb.append("Birthday: ").append(birthDay);

    return sb.toString();
  }
}

// Create and return a Map of the Object type above.
public static Map<String, Info> sortMap(String str) {
  // start parsing at first name.
  String[] firstNames = str.split("First Name");
  Map<String, Info> map = new HashMap<String, Info>();
  for (String nameStr : firstNames) {
    nameStr = safeTrim(nameStr);
    if (nameStr.length() > 0) {
      // add back the key name - 
      nameStr = "First Name" + nameStr;
      String[] fields = nameStr.split("\n");
      // The three fields to find...
      String firstName = "";
      String lastName = "";
      String birthDay = "";
      for (String f : fields) {
        // split name-value.
        String[] nv = safeTrim(f).split(":");
        if (nv.length != 2) {
          continue;
        }
        nv[0] = safeTrim(nv[0]);

        if (nv[0].equalsIgnoreCase("First Name")) {
          firstName = safeTrim(nv[1]);
        } else if (nv[0]
            .equalsIgnoreCase("Last Name")) {
          lastName = safeTrim(nv[1]);
        } else {
          birthDay = safeTrim(nv[1]);
        }
      }
      map.put(firstName, new Info(firstName,
          lastName, birthDay));
    }
  }
  return map;
}

public static void main(String[] args) {
  String str = "First Name: John\n Last Name: GrannySmith\n"
      + "Birthday: January 1 2014\n First Name: George\n "
      + "Last Name: Smith\nBirthday: January 2 2014 ";
  Map<String, Info> map = sortMap(str);
  System.out.println(map.get("John"));
}