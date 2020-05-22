int times = 10; // Say you want it 10 times, in your code it's 7.

    for (int i = 0; i < times; i++) {
        System.out.println(deck[(int) (Math.random() * deck.length)]
                 + " : " + suit[(int) (Math.random() * suit.length)]);
    }