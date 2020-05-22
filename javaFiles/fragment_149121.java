public void Modify() {   
    String Cid; 
    System.out.println("Enter your ID :");
    Scanner sc = new Scanner(System.in);
    int id = sc.nextInt();

    for (int i=0; i<stu.length;i++)
    {   
           if(id == stu[i].getId()) {
            //Change your account details
            System.out.println("Enter name ");
             name= sc.next();
             stu[i].setName(name);
            }

    }
     }