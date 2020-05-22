StringBuilder sb = new StringBuilder();
String token = null;
int counter = 1;

for (String element : elements) {
   if (!element.equals(token)) {
       if (token != null) {
           sb.append(token);
           if(counter > 1) sb.append(counter);
       }

       token = element;
       counter = 1;
   } else {
       counter++;
   }
}


// We've reached the end, add final element
sb.append(token);
if (counter > 1) sb.append(counter);
return sb.toString();