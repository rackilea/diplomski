int count = 0;
for (int i = 0; i < str.length() - 1; i++) {
  for (int j = i + 1; j < str.length; j++) {

    if(str.charAt(i)==str.charAt(j)){
       count++;
    }
}    
return count;
}