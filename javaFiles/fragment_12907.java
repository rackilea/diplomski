StringBuilder builder = new StringBuilder(text);
for (int i = 0; i < text.length(); i++) {
     if(Character.isDigit(text.charAt(i))){
            builder.insert(i, "\n"); // questionable
     }
}