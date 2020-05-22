static String snake(String u[][]){
    StringBuilder sb = new StringBuilder();
    for(int i=0; i<u.length; i++){
        if(i%2==0){
            for(int j=0; j<u[i].length; j++){
                String asli = u[i][j];
                System.out.print(asli+"");
                sb.append(asli + ",");
            }
        }else
            for(int j=u[i].length-1; j>=0; j--){
                String asli = u[i][j];
                System.out.print(asli+"");
                sb.append(asli + ",");
            }
        }
        return sb.toString();
    }