char[] arabicChars = {'٠','١','٢','٣','٤','٥','٦','٧','٨','٩'};
int  arabic_zero_unicode= 1632;
String str = "١٣٢٤٠٤٥٣";
StringBuilder builder = new StringBuilder();
boolean charFound=false;
for(int i =0; i < str.length(); ++i ) {
    charFound=false;
    for(int j=0;j<arabicChars.length;j++){
        if(str.charAt(i)==arabicChars[j]){
            builder.append((char)((int)str.charAt(i) + 48-arabic_zero_unicode));
            charFound=true;
        }
        if(!charFound)
            builder.append(str.charAt(i));

    }

}

System.out.println("Number in English : "+builder.toString());