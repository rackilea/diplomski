private void writeToFile(String list) throws IOException{
///
                File f = new File("E:\\test1.txt");
                System.out.println(f);
                FileWriter fw = new FileWriter(f,true);
                System.out.println(fw);
                try{
                    BufferedWriter bw = new BufferedWriter(fw);
                    System.out.println(bw);
                    bw.newLine();
                    bw.write(list);
                    bw.flush();
                    bw.close();
                }
                catch(Exception e){
                    System.out.println(e);
                }
                ///
}