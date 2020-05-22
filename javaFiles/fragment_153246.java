String str="{Name=jack,UserName=Jacki}";
Scanner sc=new Scanner(str);
sc.findInLine("Name=");

 if(sc.hasNext())
 {
     System.out.println(sc.next()); //This will print Name you can store it in variable as well
  }


sc.findInLine("UserName=");

if(sc.hasNext())
 {
     System.out.println(sc.next()); //This will print UserName you can store it in variable as well
  }