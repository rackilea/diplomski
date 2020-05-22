try {
            BufferedReader br=new BufferedReader(
                          new FileReader(new File("/home/ruchira/Test.txt")));
            String line;
            String text = "";
            try {
                while ((line=br.readLine())!=null){
                       if(line.contains("Austria.jpg")){
                           String line1=br.readLine();
                           if(line1!=null){
                               text=text+line1.split(": ")[1];
                           }
                       }
                }
                System.out.println(text);
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }