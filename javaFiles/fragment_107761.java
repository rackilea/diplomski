String s = "panorder_01, panorder_02, disorder_01, forkorder_01, forkorder_02, forkorder_03";
    String s2 [] = s.split(",");
    for(String s3 : s2)
    {
        if(s3.trim().contains("_01"))
            System.out.println(s3.trim());
    }