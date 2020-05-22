//try this

public class TriangularNumbers {

    public static void main(String[] args) {
        int n = 1;
        int i = 1;
        int star = starNumbers(n);
        int triangle = 0;

        while (star > 0){
            star = starNumbers(n++);
            triangle=0;
            //System.out.println("Star "+star);
            while(triangle < star){

                triangle = triangleNumbers(i,star);

                if(star == triangle){
                    System.out.println("match at "+star);
                }
            }
        }
    }

    private static int starNumbers (int n) {
        int s = ((6*n)*(n-1)+1);
        return s;
    }

    private static int triangleNumbers( int i, int star){
        int t = 0;
        while (t<star){
            t = i*(i+1)/2; //get next triangle
            i++;
        }
        return t;
    }
}