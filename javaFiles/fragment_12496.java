int[] arr = new int[30];
        List<Integer> list = new ArrayList<Integer>();
        for(int i = 1; i <= arr.length; i ++)
            list.add(i);
        Collections.shuffle(list);
        for(int i = 0; i < arr.length; i++)
            arr[i] = list.get(i);