Map<String,Integer> phonebook = new HashMap<>();
  Scanner in = new Scanner(System.in);
  int n=in.nextInt();
  in.nextLine();
  for(int i=0;i<n;i++)
  {
     String name=in.nextLine();
     int phone=in.nextInt();
     in.nextLine();
      phonebook.put(name,phone);
  }
  while(in.hasNext())
  {
     String s=in.nextLine();
     Integer phone = phonebook.get(s);
     if(phone==null){
         System.out.println("Not found");
     } else {
         System.out.println(s+"="+phone);
     }
  }