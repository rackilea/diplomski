for (int i = 0; i < 7; i++) {
    for (String lines : MyArray()) {
        // Changes depended by values.
        if (i > 3) {   
            lines = MyValx;
        }

        System.out.println(lines); // to have `\n` effect
    }
    System.out.println();
}