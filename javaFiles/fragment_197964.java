String sPhoneNumber1 = "605-888-9999";
  String sPhoneNumber2 = "605-888-9991";
  //String sPhoneNumber3 = "605-8838-9993";

  Pattern pattern = Pattern.compile("\\d{3}-\\d{3}-\\d{3}");
  Matcher matcher = pattern.matcher(sPhoneNumber);

  if (matcher.matches()) {
      System.out.println("Phone Number Valid");
  }
  else
  {
      System.out.println("Phone Number must be in the form XXX-XXXXXXX");
  }