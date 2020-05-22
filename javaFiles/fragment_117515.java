class Main{
     public static <T> List<T> modifiedList(final List<T> list)
     {
         return new Main$1<T>(list);
     }

     public static void main(String[] args) 
     {
         List<String> originalList=new ArrayList<String>();
         List<String> duplicateList=modifiedList(originalList);
         originalList.add("1");
         originalList.add("2");
         originalList.add("3");
         System.out.println(originalList+" "+duplicateList);
         duplicateList.add("4");
         duplicateList.add("5");
         duplicateList.add("6");
         System.out.println(originalList+" "+duplicateList);
     }