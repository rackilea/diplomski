for(DataSet dataSet : db){
   System.out.println(dataSet.arrayItem.size());
   for(String s : dataSet.arrayItem){
       System.out.println(s);
   }
}