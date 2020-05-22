public static String[][] load() {

   try{
      FileReader fr = new FileReader("c:/temp/Address.txt");
      BufferedReader bf = new BufferedReader(fr);
      String presentLine = "";
      for(int i = 0; i < 20; i++) {
        for(int j = 0; i < 5; j++) {
             if ((presentLine = bf.readLine()) != null) {
                   array[i][j] = presentLine;
             }
        }
      }
   } catch(Exception e) {
      System.out.println(e);
   }

   selectMenu();
   return array;
}