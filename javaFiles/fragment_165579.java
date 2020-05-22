//  Rules separated in 3 parts only for convenience
    String rules1= "< A < B < C < D < E < F < G < H < I < J < K < L < M < N < O < P < Q < R < S < T < U < V < W < X < Y < Z" ;
    String rules2= "< a < b < c < d < e < f < g < h < i < j < k < l < m < n < o < p < q < r < s < t < u < v < w < x < y < z" ;
    String rules3= "< 0 < 1 < 2 < 3 < 4 < 5 < 6 < 7 < 8 < 9" ;
    RuleBasedCollator collator= new RuleBasedCollator(rules1+rules2+rules3) ;

    String input= "h498y948759hrh98A722hjDF94yugerTEr892ur48y" ;

    //  Bulk of the job done here
    String[] arr= input.split("") ;
    Arrays.sort(arr,1,arr.length,collator);

    //  Join back in a single string for presentation
    StringBuilder sb= new StringBuilder() ;
    for(String e: arr )
        sb.append( e );
    System.out.println(sb);