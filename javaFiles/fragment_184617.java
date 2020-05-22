OutputStream out = new FileOutputStream("yourfilepath.bin");
     ObjectOutputStream outputStream = new ObjectOutputStream(out);

     Student s1 = new Student("100383", "JOHN", "MITCHELL");
     Student s2 = new Student("100346", "AMY", "CHING");


     outputStream.writeObject(s1);
     outputStream.writeObject(s2);
     outputStream.writeObject(null);//to realize that you reach the end of file

     outputStream.close();
     out.close();

     InputStream in = new FileInputStream("yourfilepath.bin");
     ObjectInputStream inputStream = new ObjectInputStream(in);

     Student temp = null;

     while((temp =(Student)inputStream.readObject())!=null){
         System.out.println(temp.id+","+temp.name+","+temp.surname);
     }