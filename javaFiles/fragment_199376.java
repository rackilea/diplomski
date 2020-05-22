String Fullname , Firstname , Lastname;

   Scanner input = new Scanner(System.in);
   System.out.println("Enter Full Name");
   Fullname = input.nextLine();

        StringTokenizer st = new StringTokenizer(Fullname, " ");
        Firstname = st.nextToken();
        Lastname = st.nextToken();
        System.out.println("First Name: "+Firstname);
        System.out.println("Last Name: "+Lastname);