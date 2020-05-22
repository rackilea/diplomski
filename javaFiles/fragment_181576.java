if(this.eolCharacter.equalsIgnoreCase("CR")){
   return input.replaceAll("(\\r)?\\n", "\r");
}else if(this.eolCharacter.equalsIgnoreCase("LF")){
   return input.replaceAll("\\r(\\n)?", "\n");
}else{
   return input.replaceAll("((\\r)?\\n)|(\\r(?!\\n))", "\r\n");
}