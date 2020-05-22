import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class OrderTheListBasedOnItemDeleted {


    public static void main(String[] args) {

        List<String> idList = new ArrayList<String>();
        String idToBeDeleted="5a";

        String idString= "1,2a,2b,2c,3,4,5a,5b";

        String idArray[]=idString.split(",");

        for(int i=0;i<idArray.length;i++){
            idList.add(idArray[i]); 
        }


        int duplicateCount=0;
         List<Integer>indexOfItemsForReorder = new ArrayList<Integer>();

            Pattern patternDigit = Pattern.compile("\\d+",Pattern.CASE_INSENSITIVE);
            Pattern patternLetter = Pattern.compile("[a-zA-Z]+",Pattern.CASE_INSENSITIVE);
            String digit="";
            String letter="";
            String digit2="";
            String letter2="";


        for(String a :idList){
            System.out.println(a);
        }
        System.out.println();


        Matcher mD = patternDigit.matcher(idToBeDeleted);
        Matcher mL = patternLetter.matcher(idToBeDeleted);
        if (mD.find()) {
            digit  = mD.group();
        }
        if (mL.find()) {
            letter  = mL.group();
        }


        if(letter!=""){
                for(String idToBeDeleted : idList){

                            Pattern patternDigitLetter = Pattern.compile(digit+"[a-zA-Z]+",Pattern.CASE_INSENSITIVE);   
                            Matcher digitletterMatcher = patternDigitLetter.matcher(idToBeDeleted);
                            if(digitletterMatcher.find()){
                                indexOfItemsForReorder.add(idList.indexOf(digitletterMatcher.group()));
                                duplicateCount=duplicateCount+1;
                            }
                }
                int indexofContentToBeReplaced = indexOfItemsForReorder.get(indexOfItemsForReorder.size()-1);
                //for letter more than 2...
                if(duplicateCount>2){
                    idList.remove(indexofContentToBeReplaced);
                }else if(duplicateCount>=1&&duplicateCount<=2){
                    //for letter more than 1 and less than 2...

                    idList.remove(indexofContentToBeReplaced);
                    idList.remove(indexofContentToBeReplaced-1);
                    idList.add(indexofContentToBeReplaced-1, digit);


                }


                System.out.println("result...");

    }else{
            int indexOfItemToBeDeleted=idList.indexOf(idToBeDeleted);       
            List <String> newIdList = new ArrayList<String>();

            for(int i=0;i<indexOfItemToBeDeleted ;i++){

                newIdList.add(idList.get(i));
            }
            idList.remove(idToBeDeleted);

            for(int i=indexOfItemToBeDeleted; i<idList.size(); i++){
                digit2="";
                letter2="";
                Matcher mD2 = patternDigit.matcher(idList.get(i));
                Matcher mL2 = patternLetter.matcher(idList.get(i));
                if(mD2.find()){
                    digit2=mD2.group();
                }

                if (mL2.find()) {
                    letter2  = mL2.group();
                }

                int d=Integer.parseInt(digit2);
                d=d-1;
                newIdList.add(i, Integer.toString(d)+letter2);

            }

            if(newIdList.contains("0")){
                newIdList.remove("0");
            }


            System.out.println("result...");
            idList.clear();
            idList=newIdList;
    }

        for(String a :idList){
            System.out.println(a);
        }


    }
}