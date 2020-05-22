public String printTriangleType(int a, int b, int c) {
   if (a == b && b == c) 
      return "equilateral";
   else if (a == b && b != c && a != c) 
      return "isosceles";
   else if (a == c && b != c && b != a) 
      return "isosceles";
   else if (b == c && c != b && c != a) 
      return "isosceles";
   else
      return "scalene";
}