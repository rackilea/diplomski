String[] col;
    List<String[]> list = new ArrayList<String[]>();    

    col = new String[3];        
    col[0] = "1";
    col[1] = "hello";
    col[2] = "1,2,3,4";
    list.add(col);

    col = new String[3];
    col[0] = "2"; 
    col[1] = "hi";
    col[2] = "4,3,2,1";
    list.add(col);


    for(String[] objs : list){
        for(String str : objs){
            System.out.print(str + "\t");
        }
        System.out.println();
    }