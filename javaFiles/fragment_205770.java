public static void main(String[] args){
        Scanner s=new Scanner(System.in);
        int size=Integer.parseInt(s.nextLine());
        long arr[]=new long[size];
        for(int i=0;i<size;i++){
            arr[i]=s.nextLong();
        }
        long minIndex=0;
        Double minNo=Double.MAX_VALUE;
        Double[] prefixedMult = new Double[size];
        prefixedMult[0] = Math.log10((double)arr[0]);
        for(int k =1; k< size; k++){
            prefixedMult[k] = prefixedMult[k-1] + Math.log10((double)arr[k]);
        }

        for(int k=0;k<size;k++){
            Double part1 = prefixedMult[k]; //multiplication of A[1]*A[2]A[3].........*A[k]
            Double part2 = prefixedMult[size-1] - (part1);    //multiplication of A[k+1]A[k+2]...........*A[size]
            Double diff = Math.abs(part1 - part2);
            if(minNo > diff){
                minNo=diff;
                minIndex=k;
            }
        }
        System.out.println("MinNo: "+minNo+" Index: "+minIndex);
    }