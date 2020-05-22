public boolean isSuperAnagram(String s, String st){
    s.toLowerCase();
    st.toLowerCase();
    char[] array1 = s.toCharArray();
    char[] array2 = st.toCharArray();

    boolean myFlag = true; // flag is initially true to enter the loop

    // added another condition to the loop - will exit if myFlag == false
    for(int i = 0; i < array1.length && myFlag; i++){
        myFlag = false;
        for(int j = 0; j < array2.length; j++){
           if (array1[i] == array2[j]){
               array2[j] = ' ';
               myFlag = true;   // found a match, set our flag == true
               // we only want to replace ONE letter, not ALL (so break out of the loop)
               break; 
           }
        }
    }

    // will only return true if every letter in array1 matched some letter in array2
    return myFlag;
}