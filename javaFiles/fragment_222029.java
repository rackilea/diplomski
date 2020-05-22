decimal = val



for(val = decimal; val > 0; val = val / 8){
octalString = val % 8 + octalString;
}