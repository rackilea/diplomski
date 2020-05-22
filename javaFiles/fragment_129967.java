try {
      BufferedReader bufferedReader = new BufferedReader(new InputStreamReader
          (new FileInputStream("pathofthtextfile")));
       while(true) {
          String line = bufferedReader.readLine();
          if (line == null) {
                break;
          }
          else{
             String[] data = line.split("\\s+");
             System.out.println(data[4]);
          }
}

} catch (FileNotFoundException e) {
            e.printStackTrace();
} catch (IOException e) {
            e.printStackTrace();
}