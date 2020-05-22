InputStream in = new FileInputStream("Your file's path");
     BufferedReader br = new BufferedReader(new InputStreamReader(in));
     String str;
     ArrayList<Student> list = new ArrayList<>();
     while((str=br.readLine())!=null){
         if(str.equalsIgnoreCase("student")){
             String id=null,name=null,surname=null;
             if((str=br.readLine())!=null){
             id = str;
             /*if id is int use
              * int id = Integer.parseInt(sc.nextLine());
              */
             }
             if((str=br.readLine())!=null){
                 name = str;
             }
             if((str=br.readLine())!=null){
                 surname = str;
             }
             list.add(new Student(id,name,surname));
         }
     }