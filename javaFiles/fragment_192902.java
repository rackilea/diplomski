public class SO4 {
public static void main(String[] args) {

    String words = "adaahhhccadcdaccaaddadddcchah";  //String from doc
    String[] wordsToColour = {"ahhh", "acca", "adda", "hah" };   //Words we want to find
    ArrayList<Integer> points = new ArrayList<Integer>(); //Hold indexes of words

    //Get the points of the words to colour first and add them to points arrayList
    int j, k =0, count = 0;
    String checker = "";
    while(count < wordsToColour.length){ //For each search word
        j = 0; //start of search word
        k = wordsToColour[count].length();  //end of current search word
        while(k < words.length() + 1){ //we will search whole string
            checker = words.substring(j, k);  //String equal to a substring the same length as the word we are searching for 
                if(checker.equals(wordsToColour[count])){ //If we find our word
                    points.add(Integer.valueOf(j)); //Store co-ordinates in arrayList, co-ordinate being the index at which the word is found
                    points.add(Integer.valueOf(k)); //Store co-ordinates in arrayList co-ordinate being the index at which the word is found
                }
            j++;
            k++;
        }//Inner loop
        count++;
    }//Outer loop

    //Checking the arrayList to see if it contains our words. 
/*        k=0; j=1;
     while(j < points.size()){  
         System.out.println(points.get(k) + " " + points.get(j) + " Word: " + words.substring(points.get(k), points.get(j)));
         k = (k+2);
        j = (j + 2);
     }   */


     //This will hold a reference to either a letter or a word to colour 
     ArrayList<String> wordsByElement = new ArrayList<String>(words.length());  
     k = 0; j = 0;
     String storage;  //Will hold reference to current substring
     while(j < words.length()){
         storage = words.substring(j, j+1); //Will iterate over each letter
         if(j == points.get(k)){ //If we hit a point stored in points array
             //Use points in array to add substring word to wordsByElement ArrayList
             wordsByElement.add(words.substring(points.get(k), points.get(k+1))); //Adding
             j = points.get(k + 1) -1; //Set j to continue at the point after the word we just extracted 
             k = (k + 2); //raise k to start point of next word we want
         }/*Inner if */ else { //If we didn't get a match
             wordsByElement.add(storage); //add the letter
         }
     j++;
     }//While loop end


             //This shows what is in the ArrayList and should show what I have done to this point
         for(String s : wordsByElement){
         System.out.println(s); //Checking what is in our ArrayList
     } 

      XWPFDocument newDoc = new XWPFDocument(); //Doc to write new doc to
      XWPFParagraph para = newDoc.createParagraph(); //Paragraph
      XWPFRun run = para.createRun();  //Where the text will be written from
     k=0;

     while(k < wordsByElement.size()){
         run = para.createRun();
         switch (wordsByElement.get(k)) {
        case "ahhh": //If word is ahhh
            run.setColor("ff5400"); //Set Color
            break;
        case "acca": //If word is acca
            run.setColor("a7bf42"); //set color
            break;
        case "adda": //So on
            run.setColor("7b8896"); //so forth
            break;
        case "hah":
            run.setColor("00adee");
            break;
        default: //If word is not one of the above
            run.setColor("000000"); //Color is black
            break;
        }

         run.setText((wordsByElement.get(k))); 
         k++;
     }

     try {
        newDoc.write(new FileOutputStream(new File("D:\\Users\\user277005\\Desktop\\testerFinished.docx")));

        //View our document
        if(Desktop.isDesktopSupported()){
            Desktop.getDesktop().open(new File("D:\\Users\\user277005\\Desktop\\testerFinished.docx"));
        }

    } catch (IOException e) {
        e.printStackTrace();
    } //save

}
}