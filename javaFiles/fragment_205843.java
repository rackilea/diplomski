final List<String> fname = new ArrayList<String>(Arrays.asList(fullname.split("")));
    // defining a list that will hold the unique elements.
    final List<String> resultList = new ArrayList<>();
    // defining a list that will hold the number of replication for every item in the fname list; the order here is same to the order in resultList
    final ArrayList<Integer> counter = new ArrayList<>();

    for (int element = 0; element < fname.size(); element++) {
        int count = 1;
        for (int run = (element + 1); run < fname.size(); run++) {
            if ((fname.get(element)).equals(fname.get(run))) {
                count++;
                // we remove the element that has been already counted and return the index one step back to start counting over.
                fname.remove(run--);
            }
        }
        // we add the element to the resulted list and counter of that element
        counter.add(count);
        resultList.add(fname.get(element));
    }
    // here we print out both lists.
    System.out.println(resultList);
    System.out.println(counter);