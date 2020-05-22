private int X_SIZE = 155;


 public int getX(int position) {
     return (position - 1) % X_SIZE + 1;   // Starts from 1
 }

 public int getY(int position) {
     return (position - 1) / X_SIZE + 1;   // starts from 1
 }