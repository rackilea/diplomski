import java.util.ArrayList;


public class Comment {


    public static void main(String[] args) {
        String comment = "";
        //This will hold the comments after split
        ArrayList<String> splittedComments = new ArrayList<String>();
        while(comment.length() > 500)
        {
            String splitCOmment = comment.substring(0,500);

            int lastIndexOfWhiteSapce = splitCOmment.lastIndexOf(" ");
            splitCOmment = splitCOmment.substring(0,lastIndexOfWhiteSapce);
            splittedComments.add(splitCOmment);
            //trim off the taken comment and process again
            comment = comment.substring(lastIndexOfWhiteSapce).trim();
        }
        splittedComments.add(comment);
    }
}