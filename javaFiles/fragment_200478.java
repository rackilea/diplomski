if (cap.matches("(?s).*[\\u0600-\\u06FF\\u0750-\\u077F\\uFB50-\\uFDFF\\uFE70‌​-\\uFEFF].*"))
{
    /*There is an Urdu character*/
} 
else if (cap.matches("(?s).*\\p{InArabic}.*"))
{  
    /* The string contains an Arabic character */ 
}
else { /*No Arabic nor Urdu chars detected */ }