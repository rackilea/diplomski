public static void writeLineByLine(){

    try{
      File fout = new File("out.txt");
      FileOutputStream fos = new FileOutputStream(fout);

      BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(fos));

      for (String text : list) {
        bw.write(text);
        bw.newLine();
      }

    }catch (IOException  e){
      // handle exceptioin        
    }finally{
     bw.close();
    }
}