File file = new File("Your file's path");
     Scanner sc=null;
     try {
        sc = new Scanner(file);
     } catch (FileNotFoundException e) {
        e.printStackTrace();
     }
     ArrayList<Student> list = new ArrayList<>();
     while(sc.hasNextLine()){
         if(sc.nextLine().equalsIgnoreCase("student")){
             //Assuming each property is in the seperate line of file
         String id,name,surname=null;
         if(sc.hasNextLine()){
         id = sc.nextLine();
         /*if id is int use
          * int id = Integer.parseInt(sc.nextLine());
          */
         }
         if(sc.hasNextLine()){
             name = sc.nextLine();
         }
         if(sc.hasNextLine()){
             surname = sc.nextLine();
         }
         list.add(new Student(id,name,surname));

         }
     }