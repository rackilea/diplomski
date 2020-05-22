for (int i = 0; i < array.length; ++i) {
    print(i);   // print the number *without* a line break after it

    if (i % 3 == 0) {
        println();    // add a line break after every third element
    } else {
        print(" ");
    }
}

println();