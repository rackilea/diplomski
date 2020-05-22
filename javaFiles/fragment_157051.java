Query qry="-----";//valid query

List<Object[]> list=(List<Object[]>)qry.list();
System.out.println(" Size of list is "+list.size());// i'm getting 2

Object[] firstRow =list.get(0);

System.out.println(firstRow[0]);// will output shiftNameId
System.out.println(firstRow[1]);// will output shiftName
...