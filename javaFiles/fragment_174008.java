import java.util.*;
class Uniques {

    static class Pair {
        int a;
        int b;
        Pair(int a, int b) { this.a = a; this.b = b; }
        public boolean equals(Object o) {
            if(o instanceof Pair) {
                Pair p = (Pair)o;
                if(a == p.a && b == p.b) return true;
                // check reverse, as per comment from @Chance
                if(a == p.b && b == p.a) return true;
            }
            return false;
        }
        // poor hashcode, for sure, but we need hash(a,b) == hash(b,a)...
        public int hashCode() { return a ^ b; }
        public String toString() { return "Pair (" + a + "," + b + ")"; }
    }

    static Random rand = new Random(); // in the class or something?
    static Set<Pair> generatePairs(int[] alphabet, int num) {
        Set<Pair> set = new HashSet<Pair>();
        int size = alphabet.length * alphabet.length; // pretend it's a matrix 
        while(set.size() < num) {
            int both = rand.nextInt(size); // only works up to alphabet.length < 2^15
            int apos = both % alphabet.length;
            int bpos = both / alphabet.length;
            int a = alphabet[apos];
            int b = alphabet[bpos];
            Pair pair = new Pair(a,b);
            set.add(pair);
        }
        return set;
    }

    public static void main(String...args) {
        int[] nums = new int[10];
        int p = 2;
        // seed with prime numbers up to 10000
        for(int i = 0; i < nums.length; i++) {
            while(!isPrime(p)) p++;
            nums[i] = p++;
        }
        // just double checking I don't suck at isPrime() haha
        //for(int i : nums) System.out.println(i);

        // okay we have our numbers, now let's get some stuff out of them
        Set<Pair> pairs = generatePairs(nums, 20);
        for(Pair pair : pairs) System.out.println(pair);
    }

    public static boolean isPrime(int p) {
        if(p == 2) return true;
        if(p % 2 == 0) return false;
        int q = (int)(Math.sqrt(p) + 1);
        for(int i = 3; i < q; i +=2) {
            if(p % i == 0) return false;
        }
        return true;
    }

}