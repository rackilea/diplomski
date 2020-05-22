public static int reverseString(StringBuffer s){ 
    StringBuffer s1=new StringBuffer(""); 
    int length=s.length(); 
    for(int i=length-1;i>=0;i--){ 
        s1.append(s.charAt(i)); 

    } 
    s.replace(0, length, s1.toString()); 
    return 1; 
}