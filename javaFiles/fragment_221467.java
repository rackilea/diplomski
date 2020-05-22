for(int i=1; i<s.length(); i++){
    if(s.charAt(i) != currentChar){
        encodedString.append(String.valueOf(currentChar) + counter);
        currentChar = s.charAt(i);
        counter = 1;
    } else counter++;
}
encodedString.append(String.valueOf(currentChar) + counter); // Here