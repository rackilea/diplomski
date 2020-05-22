String content = tdElement2.text().replace(",", "");
//I added the following code to avoid that 'Â'
String content2 = content.replace("\u00a0","");
if (it2.hasNext()) {
 sb.append(formatData(content2));
 sb.append("   ,   ");
}