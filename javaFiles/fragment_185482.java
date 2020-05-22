File f = new File("E:\\test1.txt");
try{
       FileReader fr = new FileReader(f);
       BufferedReader br = new BufferedReader(fr);
       while(br.ready()){
       System.out.println(br.readLine());
        }
}catch(Exception e){
    System.out.println(e);
}
}