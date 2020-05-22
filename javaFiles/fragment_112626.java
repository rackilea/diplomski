do {
    System.out.println("Enter 'q' for quit!!");
    str=br.readLine();
    FileWriter fw=new FileWriter(file,true);
    bw=new BufferedWriter(fw);
    bw.write(str);
    bw.flush();    //do this , you missed it
    System.out.println(str);
}
while(!(str.equalsIgnoreCase("q")));

bw.close();     //do this , you missed it