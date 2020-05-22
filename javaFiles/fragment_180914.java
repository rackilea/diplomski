StringBuilder answer = new StringBuilder();
String s
 = "This is a sample sentence so that Ang Mo Kio Avenue 1 is part of Ang Mo Kio.";
    String[] words = s.split("\\s+");
    int count=0;
    for (int i = 0; i < words.length; i++) {
        char firstChar=words[i].charAt(0);
        if (Character.isUpperCase(firstChar) 
                 ||(count>0  && Character.isDigit(firstChar))) {
            answer.append(" "+words[i]);
            count++;
        } else {
            //To avoid less than 3 word apply this logic.
            if(count>2){
            System.out.println(answer);
            }
            count=0;
            answer = new StringBuilder();
        }
    }
    System.out.println(answer);// Also need to print answer here.