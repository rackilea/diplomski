public ReadFileToList() throws IOException{
    FileReader fr=new FileReader("D:/AllUserRecords.txt"); //one slash instead of two backslash
    BufferedReader br=new BufferedReader(fr);
    String line = br.readLine();
    while((line=br.readLine()) !=null){
        data.add(line.trim());  //trim() delete spaces before and after line
        System.out.println(line);
    }
    br.close();
    Arraydata = new String[data.size()][];
    for (int i=0;i<data.size();i++){
        Arraydata[i]=data.get(i).split(" "); //split text to array by space
    }

}