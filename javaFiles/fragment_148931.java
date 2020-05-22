//First
if ((updatedData.elementAt(r).get(c).get(1).toString().equals("null"))) 
{
updatedData.elementAt(r).get(c).set(1,"0");   
}
//Second
if (!(updatedData.elementAt(r).get(c).get(1).toString().equals("null"))) 
{
updateQuery +=updatedData.elementAt(r).get(c).get(0)+"='"+updatedData.elementAt(r).get(c).get(1)+"', " ;
insertColValsStr += " '"+updatedData.elementAt(r).get(c).get(1)+"') ";        
}
else
{
updateQuery += updatedData.elementAt(r).get(c).get(0)+"=null " ;
insertColValsStr += " null ) " ;       
}