public void GetAll ()
 {
    System.out.println("Book name : "+name+", Authors :   ");
    for (int i=0; i<author.length;i++)
     {
          System.out.print(Arrays.asList(author[i].ToAll())+" ,"); 
     }
     System.out.println("Price : "+price+"");
  }