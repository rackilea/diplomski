for (int i = 0; i <=1000000000; i++) {
    f=new File("myfile" + i + ".txt");
    if (!f.exists()){
        try {

            f.createNewFile();
            FileWriter fileWriter = new FileWriter(f);
            fileWriter.write(dateFormat.format(date));
            fileWriter.flush();
            fileWriter.close();

        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        System.out.println("File Written");
        break; // <==== Break out of the for-loop
   } // if
} // for