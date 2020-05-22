void foo(int param1, String param2, ...) {
    switch (param1) {
        case 0:
            foo(1, "some string");
            break;

        case 1:
            //do something
            break;

        default:
            break;
    }
}