int j=0;
    Map<Integer,Integer> numberMap=new HashMap<Integer,Integer>();
    SecureRandom random = new SecureRandom(); 
    while(j!=10)
    {
        int row = random.nextInt(list.size()); 
        if(!numberMap.containsKey(Integer.valueOf(row)))
        {
            numberMap.put(Integer.valueOf(row), Integer.valueOf(row));
            System.out.println("Row "+row+"="+list.get(row));
            j++;
        }
    }