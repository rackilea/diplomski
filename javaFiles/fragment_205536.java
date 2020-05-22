public String toString()
 {
   String x = "Radius: " + this.radius +"\n";
   String y = "Area: " + getArea() + "\n";

   String z = x + y;
   return z + super.toString();
 }