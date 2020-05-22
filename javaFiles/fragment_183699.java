NodeList entries =  datalist.getChildNodes();
for(int j=0;j<entries.getLength();j++)
{
System.out.println(entries.item(j).getNodeName() + 
"<<<>>>>" + entries.item(j).getNodeType());
}