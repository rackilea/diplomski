public static int[] answer2(int[] data, int n) {
    if (data.length>99){
        System.exit(0);
    }
    ArrayList<Integer> temp = new ArrayList<>();
    int count;

    for (int i = 0; i < data.length; i++) {
        count = 0;
        for (int j = 0; j < data.length; j++) {
            if (data[i] == data[j]) {
                count++;
            }
        }

        if (count <= n){
            temp.add(data[i]);
        }
    }


    data = new int[temp.size()];
    for (int i = 0; i <temp.size() ; i++) {
        data[i] = temp.get(i);
    }
    return data;
  }