public static void main (String[] args) throws java.lang.Exception
{
    int n = 2;
    int r = 3;
    int nn = n + 1;
    int p = 1;
    for (int i=0; i<r; i++)
      p *= nn;
    for (int i=0; i<p; i++){
        int t = i;
        String comb = "(";
        for (int j=0; j<r; j++){
            comb = comb + String.format("%2d, ", t % nn);
            t = t / nn;
        }
        comb = comb.substring(0, comb.length()-2) + ')';
        System.out.println(comb);
    }
}