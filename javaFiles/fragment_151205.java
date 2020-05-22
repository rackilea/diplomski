String text = "fast car";
String newMsg = "";
int shift = 1;
for (int i = 0; i < text.length(); i++) {
      char c = text.charAt(i);
      char character = (char)(c != ' ' ? c + shift : c); // first space check

      if (character >= 'a' && character <= 'z') {

          newMsg += character;

      } else if (character == ' ') newMsg += ' '; // second space check
      else if (character > 'z') {

          newMsg += (char)((char)(c - (26 - shift)));
      }

System.out.println(newMsg); // prints gbtu dbs