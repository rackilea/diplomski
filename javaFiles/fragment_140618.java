public class Enumerator {
    private int maxDepth;
    private int currentDepth;
    private int currentPerm;
    private String alphabet;

    public Enumerator(String alphabet, int d) {
        this.maxDepth = d;
        this.currentDepth = 1;
        this.currentPerm = 0;
        this.alphabet = alphabet;
    }

    public boolean next() {
        int numPermutations = (int) Math.pow(alphabet.length(), this.currentDepth);
        boolean res=false;

        // finished if
        if ((this.currentDepth == this.maxDepth) && 
            (this.currentPerm == numPermutations - 1)) {
            res = false;
        }
        // next perm at this depth
        else if (this.currentPerm < numPermutations - 1) {
            this.currentPerm++;
            res = true;
        }
        // next depth
        else if (this.currentDepth <= this.maxDepth) {
            this.currentDepth++;
            this.currentPerm = 0;
            res = true;
        }
        return res;
    }

    public String getPermutation() {
        int tmpPerm = this.currentPerm;
        String res = "";
        for (int i=0; i<this.currentDepth; i++) {
          int ind = tmpPerm % this.alphabet.length();
          res = this.alphabet.charAt(ind) + res;
          tmpPerm /= this.alphabet.length();
        }
        return res;
    }

    public static void main(String args[]) {
        int depth = 3;
        String alphabet = "012";
        Enumerator e = new Enumerator(alphabet, depth); 
        do {
            System.out.println(e.getPermutation());
        } while (e.next());
    }
}