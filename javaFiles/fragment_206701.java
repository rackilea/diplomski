String oldArr[] = {"one", "two", "three"};

    System.out.println(Arrays.toString(oldArr));
    String newArr[] = Arrays.copyOf(oldArr, 10);
    System.out.println(Arrays.toString(newArr));
    for (int x = oldArr.length; x < newArr.length; x++) {
        newArr[x] = "unset";
    }
    System.out.println(Arrays.toString(newArr));