String str = "<p>1+: €0.09756<br>3,001+: €0.09338<br>\n" + 
   "30,001+: €0.09338<br>150,001+: €0.09338<br>750,001+: €0.09338<br></p>";

Pattern pt = Pattern.compile("(\\d+(,\\d+)?)\\+: €(\\d+(,\\d+)?(\\.\\d+)?)");
Matcher m = pt.matcher(str);    
Float lastPrice = null;

while(m.find()) {
  Integer quantity = new Integer(m.group(1).replace(",",""));
  Float price = new Float(m.group(3).replace(",","").replace(".",","));

  // Only add price if different from last
  if (! price.equals(lastPrice))
    article.addPrice(quantity, price);
  lastPrice = price;
}