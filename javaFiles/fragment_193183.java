public static void main(String[] args) {

    String stringToSearch = "<p><b><i><u>hello</u></i></b>prajakta</p>";

    // the pattern we want to search for
    Pattern p = Pattern.compile("<p><b><i><u>(\\S+)</u></i></b>");
    Matcher m = p.matcher(stringToSearch);

    // if we find a match, get the group 
    if (m.find()) {

      // get the matching group
      String codeGroup = m.group(1);

      // print the group
      System.out.format("'%s'\n", codeGroup);

    }

  }