public static void main(String[] args) throws ParseException {
try{
   Scanner in = new Scanner(System.in);
   System.out.println("Enter the path of old file");
   String oldFile = in.nextLine();
   System.out.println("Enter the path of new file");
   String newFile = in.nextLine();
   Diff d = new Diff();
   if(!oldFile.equals("") && !newFile.equals("")) {
        d.doDiff(oldFile, newFile);
    } 
}
catch (Exception e){
   e.printStackTrace();
}
}