public  List<Integer> MersennefindPrime() {
        ArrayList<Integer> array = new ArrayList<Integer>();
        for(int i=2;i<100;i++)
        {
            for(int j=2;j<=Math.sqrt(i);j++  )
            {
                if(i%j==0)
                {
                }
                else
                {
                    array.add( i );
                }
            }
        }
        return array;
    }