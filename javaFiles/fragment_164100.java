ArrayList<String> arr = new ArrayList<String>();
while (input.hasNext()){
   String str = input.next();
   try{
       int garbage = Integer.parseInt(str); //this will fail if it's not a number
   }
   catch Exception e{
       arr.add(str);// that means we want to keep it
   }

}