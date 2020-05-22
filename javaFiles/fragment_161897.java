ArrayList<String> arr = new ArrayList<String>();

    for (int i = 0; i < arr.size(); i++) {

        String t = arr.get(i);

        if (// your condition is met) {
            arr.set(i, "your new value");
        }
    }