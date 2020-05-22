BufferedReader read = new BufferedReader(new FileReader(file));
    String str;
     while((str=read.readLine())!=null)
     {
        // Your constructor assigns str to ID property of Student
        // Casting to Integer, because ID is a number
        Student s = new Student(Integer.valueOf(str)); 

        if(s.getId()==id)
            System.out.println(s.print());
     }