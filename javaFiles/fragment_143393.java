String[] array = ...

ArrayList<String> gList = new ArrayList<String>();

ArrayList<String> oList = new ArrayList<String>();

for (String word : array) {  
    if (word != null)) {  
        if (word.startsWith("g:"))   
            gList.add(word.subString(2));  
        else if (word.startsWith("o:")
            oList.add(word.subString(2));  
    } 
}