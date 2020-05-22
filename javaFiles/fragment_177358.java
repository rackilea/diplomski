ArrayList<String> countryCount = new ArrayList<String>();
ArrayList<String> portfolioCount = new ArrayList<String>();
String mainText = "USA (45)";
final Pattern p = Pattern.compile("(.*?)(?>\\()(\\d+)(?=\\)).*");
final Matcher m = p.matcher(mainText);
m.find();
countryCount.add(m.group(1)); //USA
portfolioCount.add(m.group(2)); //45