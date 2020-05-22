ArrayList<Integer> a = new ArrayList<Integer>();
    int oc = 0;
    int number = 0;

    for(int i=0; i < row; i++)
    {
        for(int j=0; j < column ; j++){
            if(a.isEmpty()){
                a.add(arr[i][j]);
            }
            else if(a.contains(arr[i][j])){

                int temp=0;
                for(int k=0; k<a.size(); k++){
                    if(a.get(k) == arr[i][j]){
                        temp++;
                    }
                }
                if(temp > oc){
                    number = arr[i][j];
                    oc = temp;
                }

                a.add(arr[i][j]);
            }
            else{
                a.add(arr[i][j]);
            }
        }

    }