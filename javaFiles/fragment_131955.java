boolean replacingRequired = true;
while ( ... reading ...) 
  if (replacingRequired) {
     putText = getText.replaceFirst("Dog", "Cat")
     if (! putText.equals(getText)) {
       // when they are different, you replaced something!
       replacingRequired = false;
     }
  ...