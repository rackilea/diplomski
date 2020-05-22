private static List<String> listQuestionE(Scanner sc, List<File> listQuestion){

       List<String> question = new ArrayList<String>();
       for(File input1 : listQuestion){
           try {
              String fPath = input1.getAbsolutePath(); 
              sc = new Scanner(input1);
              question.add(fPath);
           } catch (FileNotFoundException e) {
                e.printStackTrace();
           }
       }
       return question;
}