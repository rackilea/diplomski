PhoneNumberUtil phoneUtil = PhoneNumberUtil.getInstance();

String numberStr = "04157012311";
Set<String> allRegions = phoneUtil.getSupportedRegions();
Set<String> validRegions = new LinkedHashSet<String>();

for (String region : allRegions) {
  try {
    if (phoneUtil.isValid(phoneUtil.parse(numberStr, region))) {
      validRegions.add(region);
    }        
  } catch (NumberParseException e) {
    // Handle NumberParseException
  }
}