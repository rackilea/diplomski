void move(int speed) {
  if (collision()) {
    racket.move(diameter)
   } 
}
//inside racket
public int move(int diameter){
    return this.Y - diameter;
}