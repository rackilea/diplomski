public static void main(String args[]) {
   Scanner sc = new Scanner(System.in);
   List<String> list = new ArrayList<String>();

   System.out.println("Enter your numbers, enter 'end' when done: ");
   while(!sc.hasNext("end")){
       list.add(sc.next());
   }

   String[] flostr = list.toArray(new String[0]);
   for(String s : flostr){
       System.out.println(String.format("%.2f", Float.parseFloat(s)) +" ," + String.format("%.2f", (Math.sqrt(Float.parseFloat(s)))));
   }

}