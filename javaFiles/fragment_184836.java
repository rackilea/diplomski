String str = "~PHONE_IDX=200~PHONE_DD=100~PHONE_KK=50~";
Pattern p = Pattern.compile("~PHONE_(?<attribute>\\w+)=(?<value>\\d+)");
Matcher m = p.matcher(str);//matcher for string
while(m.find())
{
  System.out.println("Next group: "+m.group());
  System.out.println("Attribute: "+m.group("attribute"));
  System.out.println("Value: "+m.group("value"));
}