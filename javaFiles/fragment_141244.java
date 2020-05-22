public class Terminal implements Expression {
   private final int value;

   public Terminal(int value) { this.value = value; }

   public int evaluate() { return value; }

   public String toString() { return String.valueOf(value); }
 }

 public class Add implements Expression {
   private final Expression left;
   private final Expression right;

   public Add(Expression left, Expression right) {
     this.left = left;
     this.right = right;
   }

   public String toString() {
     return left.toString() + " + " + right.toString();
   }

   // leave the rest for you
 }