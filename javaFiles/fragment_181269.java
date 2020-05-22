public class Happy_numbers {        
    static int[]SQUARES={0,1,4,9,16,25,36,49,64,81};
    public static boolean is_happy(int n){
        return is_happy(n, new HashSet<Integer>());
    }
    public static boolean is_happy(int n, Collection<Integer> sofar){
        if(n==1) return true;
        else if(sofar.contains(n)) return false;

        sofar.add(n);

        if(n<10) {
            return is_happy(SQUARES[n], sofar);
        }

        char[]digits=String.format("%s", n).toCharArray();
        int s = 0;
        for(char c:digits){
            s+= SQUARES[Integer.valueOf(String.format("%s", c))];
        }

        return is_happy(s, sofar);
    }
    public static void main(String[]args){
        Collection<Integer> c1 = Arrays.asList(
                1, 7, 10, 13, 19, 23, 28, 31, 32, 44, 49, 68, 70, 79, 82, 86, 91, 94, 97, 
                100, 103, 109, 129, 130, 133, 139, 167, 176, 188, 190, 192, 193, 203, 208, 
                219, 226, 230, 236, 239, 262, 263, 280, 291, 293, 301, 302, 310, 313, 319, 
                320, 326, 329, 331, 338, 356, 362, 365, 367, 368, 376, 379, 383, 386, 391, 
                392, 397, 404, 409, 440, 446, 464, 469, 478, 487, 490, 496 );
        Collection<Integer> c2 = new ArrayList<Integer>(c1.size());
        long t = System.currentTimeMillis();
        int c = 1;
        for(int i=0;i<500;i++){
            if(is_happy(i)) {
                System.out.print(i+", ");
                if(c++ % 20 == 0) System.out.println();
                c2.add(i);
            }

        }
        t = System.currentTimeMillis()-t;
        System.out.println("\nTIME : " + t);
        System.out.println("Got them all < 500 : " + (c2.containsAll(c1) && c1.containsAll(c2)));
    }
}