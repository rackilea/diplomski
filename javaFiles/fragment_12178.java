PrintStream old = System.out;
System.setOut(new PrintStream(old) {
    @Override
    public void print(String s) {
        if (s != null && s.matches(
            ".*?\\[NoOpenHopper]\\s(Loading|Enabling)\\sNoOpenHopper.+"