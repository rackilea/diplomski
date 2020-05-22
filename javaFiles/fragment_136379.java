InputStream ins = new ObjectInputStream(new FileInputStream("c:\\student.ser"));
            Student student = (Student) ins.readObject();
            Gson gson = new Gson();

            // convert java object to JSON format,
           // and returned as JSON formatted string
           String json = gson.toJson(student );

         try {
            //write converted json data to a file named "file.json"
            FileWriter writer = new FileWriter("c:\\file.json");
            writer.write(json);
            writer.close();
            } catch (IOException e) {
               e.printStackTrace();
          }