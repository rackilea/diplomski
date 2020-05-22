NavigableSet<Integer> nums = new TreeSet<Integer>();
    nums.add(5);
    nums.add(3);
    nums.add(1);
    nums.add(2);
    nums.add(6);

    System.out.println(nums.pollFirst()); // prints "1"
    System.out.println(nums.pollFirst()); // prints "2"
    nums.add(4);
    System.out.println(nums.pollFirst()); // prints "3"
    System.out.println(nums.pollFirst()); // prints "4"