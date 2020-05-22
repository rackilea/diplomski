for (int i = 0; i < 100000; ++i) {
    boolean all = true;
    for (int j = 0; j < theSetLength && all; ++j) {
        if (!itemArrays[i].getItem(theSetInt[j]))
            all = false;
    }
    if (all) ++counter;
}