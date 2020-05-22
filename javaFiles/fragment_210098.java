public class ScrabbleAssistant { 
    //int maxScore = 0;  
    //String bestWord = "";  moved into getBestWord(), does not need class scope
    //int totalScore = 0; moved into methods, class scope could cause issues

    // added public, do not forget to give your methods a scope, changed letterScores to camelCase for readability
    public String getBestWord(List<String> options, Map<Character, Integer> letterScores) {
        String bestWord = "";
        int maxScore = 0;
        int totalScore;

        for (int i = 0; i < options.size(); i++) {

            totalScore = //what method should go here? hint: calculates the score of the given word

            if (totalScore > maxScore) {
                maxScore = totalScore;
                bestWord = // what is the best word? hint: its the current index of options 
               //return totalScore; //this is the wrong place to make a return, and you can't return an int in a class that returns a String  
             }
        }
        return // what should you return here? hint: must be a string
    }

// added public, do not forget to give your methods a scope, chnaged letterScores to camelCase for readability, removed Integer total parameter, was unnecessary
    public Integer getScore(String word, Map<Character, Integer>letterScores) {
        int totalScore = 0;

        for (int i = 0; i < word.length(); i++)  { // you were iterating through the map of letter scores, not the actual String passed in
            // you should not remove, you should use get the score of the letter from the current index of the string
            // this is fixed for you
            totalScore = totalScore + (letterScores.get(word.charAt(i).intValue();
        }

        //if (totalScore > maxScore){  This logic should not be here, this method should return the total score
        //maxScore = totalScore;
        //bestWord + word;
        //}
        return totalScore;
    }
}