Iterator itr = tList.iterator();
while(itr.hasNext()){
   Object[] s= (Object[]) itr.next();

   //now you have one array of Object for each row
   if (String.valueOf(s[1]).equals(m.getMid())) {
       System.out.println("dddd " + String.valueOf(s[1]));
   }
}