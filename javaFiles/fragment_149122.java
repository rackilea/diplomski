public static void   Addstudents()
     {

     for(int i=0; i<stu.length; i++)
    {
    stu[i]=new Stuinfo();
    System.out.println("Enter name ");
    stu[i].setName( sc.next() );
    System.out.println("Enter id  ");
    stu[i].setId( sc.next() ); 


    }

    }