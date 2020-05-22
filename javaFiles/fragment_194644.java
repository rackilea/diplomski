public int SOP(int n) {
    // r = int(n**0.5)
    int r = (int) Math.sqrt(n);                                 
    //  assert r*r <= n and (r+1)**2 > n
    if(!(r * r <= n && (r+1) * (r+1) > n))
        throw new IllegalArgumentException("Assertion error");
    // V = [n//i for i in range(1,r+1)]
    ArrayList<Integer> V = new ArrayList<Integer>();
    for(int i = 1; i < r+1; i++)
        V.add(n / i);
    //V += list(range(V[-1]-1,0,-1))
    for(int i = V[V.size()-1]; i > 0; i--)
        V.add(i);
    // S = {i:i*(i+1)//2-1 for i in V}
    HashMap<Integer, Integer> S = new HashMap<Integer, Integer>();
    for(int i : V)
         S.put(i, (i*(i+1)/2 - 1));
    // for p in range(2,r+1):
    for(int p = 2; p < r+1; p++ {
        // if S[p] > S[p-1]: 
        if S.get(p) > S.get(p-1) {
            // sp = S[p-1]
            int sp = S.get(p-1);
            // p2 = p*p
            int p2 = p * p;
            // for v in V:
            for(int v : V) {
                // if v < p2: break
                if(v < p2)
                    break;
                // S[v] -= p*(S[v//p] - sp)
                S.put(v, S.get(v) - p*(S.get(v/p)-sp));
            }
        }
    }
    // return S[n]
    return S.get(n);
}