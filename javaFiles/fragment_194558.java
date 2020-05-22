public void writeMyFile(String path){

Scanner scan = new Scanner(System.in);

File f = new File(path);

FileWriter fr = new FileWriter(f);

BufferedWriter br  = new BufferedWriter(fr);

while(true){  // its a continuos loop, so better handle it the way u want it

 br.write(new Scanner(System.in).nextLine());

 } 
}