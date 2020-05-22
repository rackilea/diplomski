List<Character> list = Arrays.asList(
        'a','b','c','d','e','f','g','h','i','j','k','l'
    );

    System.out.println(list);
    // [a, b, c, d, e, f, g, h, i, j, k, l]
    //        *        *        *        *

    rotate4(list, 2, 5, 8, 11);

    System.out.println(list);       
    // [a, b, l, d, e, c, g, h, f, j, k, i]
    //        *        *        *        *