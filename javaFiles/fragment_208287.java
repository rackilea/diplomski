String company ="{\"company_id\":4100\"data\" \"drm_user_id\":572901936637129135\"company_id\":3070,\"data\",\"company_id\":4061,\"data\"}";
Pattern pattern = Pattern.compile("\"company_id\":(\\d{4})");
Matcher matcher = pattern.matcher(company);
while (matcher.find()) {
    String companyId = matcher.group(1);
    System.out.println(companyId);
}