public static List<String> sortData(List<String> data){
            List<BigInteger>convertedData=new ArrayList<BigInteger>();
        for (String s : data) 
        {
            //System.out.println(s);
         convertedData.add(new BigInteger(s));
        }
        Collections.sort(convertedData);
        List<String>sortedData=new ArrayList<String>();

        for (BigInteger b : convertedData) 
        {
            sortedData.add(String.valueOf(b));

        }
        return sortedData;
    }