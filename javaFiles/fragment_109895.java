String A="This is a statement!"; 
String B="This is a statement! Good luck!";

if (A.length() < B.length()){   //B has more letters
        A += B.subString(A.length(), B.length()-1);
} else{ 
        B += A.subString(B.length(), A.length()-1);
}