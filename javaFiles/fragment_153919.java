StringBuilder sb = new StringBuilder(myString.length()-1);
    for(int i = 0; i < myString.length(); i++){
        if(myString.charAt(i) != firstLetter){
            sb.append(myString.charAt(i));
        }
    }
    recursiveProc(sb.toString());