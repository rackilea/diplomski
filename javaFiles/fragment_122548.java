List<Character> list = Arrays.asList(
        'a','b','c','d','e','f','g','h','i','j','k','l'
    );

    System.out.println(list);
    // [a, b, c, d, e, f, g, h, i, j, k, l]
    //     *  *  *  *  *

    System.out.println(list.subList(1, 6));
    // [b, c, d, e, f]

    Collections.rotate(list.subList(1, 6), -2);
    System.out.println(list);
    // [a, d, e, f, b, c, g, h, i, j, k, l]
    //     *  *  *  *  *