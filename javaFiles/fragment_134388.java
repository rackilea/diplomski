public void calcPrime(int inp) {
    ArrayList<Integer> arr = new ArrayList<Integer>();
    arr.add(2);
    arr.add(3);

    int counter = 4;

    while(arr.size() < inp) {
        if(counter % 2 != 0 && counter%3 != 0) {
            int temp = 4;
            while(temp*temp <= counter) {
                if(counter % temp == 0)
                    break;
                temp ++;
            }
            if(temp*temp > counter) {
                arr.add(counter);
            }
        }
        counter++;
    }

    System.out.println("finish" +arr.get(inp-1));
    }
}