public static void main(String arg[]) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    // read first line in tokenizer
    StringTokenizer s = new StringTokenizer(br.readLine());
    //parse t
    int t = Integer.parseInt(s.nextToken());

    // read second line in tokenizer
    s = new StringTokenizer(br.readLine());

    while(t-->0) {
        int n,q;
        // parse n and q (2, 3)
        n=Integer.parseInt(s.nextToken());
        q=Integer.parseInt(s.nextToken());

        int D[]= new int[n];
        int Q[]=new int[q];
        long x=1;
        // read third line in tokenizer
        s = new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++) {
            D[i]=Integer.parseInt(s.nextToken());
            x=x*D[i];
        }
        // read fourth line in tokenizer
        s = new StringTokenizer(br.readLine());
        for(int i=0;i<q;i++) {
            Q[i]=Integer.parseInt(s.nextToken());
            if(x>1000000000)
                Q[i]=0;
            else
                Q[i]=(int)(Q[i]/x);
        }
        for(int i=0;i<q;i++)
            System.out.print(Q[i]+" ");

        System.out.println("");
    }
}