public class TypeofTriangle {

    public static String triangle(int a, int b, int c) {
        if (a<b && b<c && (a*a)+(b*b)>(c*c)) {
            return "Triangular Taper";
        } else if(a<b && b<c && ((a*a)+(b*b)==(c*c))) {
            return  "Right Triangle";
        } else if (a<b && b<c && (a*a)+(b*b)<(c*c)) {
            return "Blunt Triangle";
        }   return "Not a triangle";
    }
}