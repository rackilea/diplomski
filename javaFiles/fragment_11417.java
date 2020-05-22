private static boolean setUpIsDone = false;
.....
public void setUp() {
    if (setUpIsDone) {
        return;
    }
    // do the setup
    setUpIsDone = true;
}