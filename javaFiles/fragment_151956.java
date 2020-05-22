class CreateShape implements Comparable<CreateShape> {
     private char displayChar;

     public char getDisplayChar() {
         return displayChar; 
     }

     @Override
     public int compareTo(CreateShape that) {
         return Character.compare(this.displayChar, that.displayChar);
     }
 }