public static void main(String[] args){
    String sentence = "testing1 testing2 testing3 testing4";
    String[] arrayOfWords = sentence.split(" "); // split the sentence according to the spaces
    Scanner in = new Scanner(System.in);

      //Scan first word
      System.out.println("Insert First Word");
      if(arrayOfWords[0].equals(in.next())){
            System.out.println("Insert Second Word");
            if(arrayOfWords[1].equals(in.next())){ 
               System.out.println("Insert Third Word");
               if(arrayOfWords[2].equals(in.next())){
                     System.out.println("Works good!");
               }
            }
        }
}