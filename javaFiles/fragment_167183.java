public class Employee {
  private String name;
  @JsonInclude(value = JsonInclude.Include.CUSTOM, valueFilter = DateOfBirthFilter.class)
  private Date dateOfBirth;
  @JsonInclude(content = JsonInclude.Include.CUSTOM, contentFilter = PhoneFilter.class)
  private Map<String, String> phones;
}

public class DateOfBirthFilter {

  @Override
  public boolean equals(Object obj) {
      if (obj == null || !(obj instanceof Date)) {
          return false;
      }
      //date should be in the past
      Date date = (Date) obj;
      return !date.before(new Date());
  }
}

public class PhoneFilter {
  private static Pattern phonePattern = Pattern.compile("\\d{3}-\\d{3}-\\d{4}");

  @Override
  public boolean equals(Object obj) {
      if (obj == null || !(obj instanceof String)) {
          return false;
      }
      //phone must match the regex pattern
      return !phonePattern.matcher(obj.toString()).matches();
  }
}