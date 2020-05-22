System.out.println("Enter first key");
    int f=scan.nextInt();
    System.out.println("Enter second key");
    int s=scan.nextInt();
    ArrayList<String> t1=new ArrayList<String>();
    ArrayList<String> t2=new ArrayList<String>();
    ArrayList<String> mf=new ArrayList<String>();
    t1.addAll(map.get(f));
    t2.addAll(map.get(s));
    for(String temp1:t1)
    {
        if(t2.contains(temp1))
        {
            mf.add(temp1);
        }
    }