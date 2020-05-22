void A() {
    for(int i = 0; i < 10; i++)
        if(B(i))
            break;
}

boolean B(int x) {
    if(x == 4)
        return true; // stop loop
    else
        return false; // keep looping

    // or just "return x == 4;"
}