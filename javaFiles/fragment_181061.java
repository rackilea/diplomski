String[] cod = new String[count];
    String[] desc = new String[count];
    String[] preco = new String[count];
    for(int i = 0; i<count; i++){
       String[] res = array.get(i);

       cod[i] = res[0] ;
       desc[i] = res[1];
       preco[i] = res[3] ;
    }