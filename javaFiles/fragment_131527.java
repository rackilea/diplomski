public static int Search(String[] thewords, String answer) {  
     if(thewords == null) {  
        throw new NullPointerException();  
     }  
     String[] copy = new String[thewords.length];  
     System.arraycopy(thewords,0,copy,0,copy.length);  
     Arrays.sort(thewords);  
     int idx = Arrays.binarySearch(thewords, answer);  
     return idx < 0? -1:idx;  
}