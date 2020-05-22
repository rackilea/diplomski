if (x < 0 || x > 200 || y < 0) {
     System.out.print("The point isn't in the triangle");
 } else if ( y <= calculateY(x)) {
     System.out.print("The point is in the the triangle");
 } else
     System.out.print("The point isn't in the triangle");
 }