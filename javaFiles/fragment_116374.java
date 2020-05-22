static String[][] arr = new String[4][4];
static Integer[][] arr2 = new Integer[4][4];


for(int i = 0; i < arr.length; i++){
        for (int j = 0; j < arr[0].length; j++) {
            arr[i][j] = "1";
            arr2[i][j] = Integer.parseInt(arr[i][j]);
            if(arr2[i][j] instanceof Integer){
                System.out.println("Works");
            }
        }
    }