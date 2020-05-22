for (int i = 0; i < arr.length;) {
        int count = 1;
        int num = arr[i];
        while(++i < arr.length && arr[i] == num) {
            count++;
        }
        System.out.println("Number of instances to: " + num + " : " + count);
    }