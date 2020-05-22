public static void main(String[] args){
        //input.txt file is kept at the same place as that of class ReadFile
        File file=new File(ReadFile.class.getResource("input.txt").getFile());
        //User List
        List<String> userList=new LinkedList<String>();
        //Score List
        List<String> scoreList=new LinkedList<String>();
        int count =1;
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String sCurrentLine;
            while ((sCurrentLine = br.readLine()) != null) {
                if(count%2==0){
                    //Line is even
                    scoreList.add(sCurrentLine);
                }else{
                    //Line is odd
                    userList.add(sCurrentLine);
                }
                count++;
            }
        System.out.println("Printing User List:"+userList+"\n\nPrinting Score List:"+scoreList);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }