HashSet<Integer> list = new HashSet<Integer>();
        Random rand = new Random();
        while(list.size() != 30) {
            list.add((int)(Math.random()*30+1));
        }
        List<Integer> randomlist = new ArrayList<Integer>(list);
        Collections.shuffle(randomlist);
        int[] arr = new int[30];
        for(int i = 0; i < arr.length; i++)
            arr[i] = randomlist .get(i);