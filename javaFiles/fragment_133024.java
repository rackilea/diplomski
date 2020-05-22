Elements tds = row.select("td");
count = 0;
for (Element element : tds) {
if(!element.text().isEmpty() && element.children().isEmpty()){
    count++;
    System.out.println("line "+count+" text = '"+element.text()+"'");
}