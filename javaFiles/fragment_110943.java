String listAsString = "";
List<Object[]> list = (List<Object[]>) q.list();
Iterator iter = list.iterator();
while(iter.hasNext()) {
     Object[] result = (Object[]) iter.next();
     listAsString += "Name: "+result[0]+" and code: "+result[1]+ "\n";
}
return listAsString;