static Pattern p = Pattern.compile("PT(?:([0-9]+)H)?(?:([0-9]+)M)?(?:([0-9]+)S)?");

static void parse(String s){
  Matcher m = p.matcher(s);
  m.find();
  String hh = m.group(1);
  String mm = m.group(2);
  String ss = m.group(3);
  System.out.println("s="+s+" hh="+hh+" mm="+mm+" ss="+ss);
}