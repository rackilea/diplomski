interface Flag {
    String getType();
    int getValue();
    enum A implements Flag{
        one, two, three;
        String getType() { return getClass().getSimpleName(); }
        int getvalue() { return ordinal()+1; }
    }
    enum B implements Flag{
        four, five, six;
        String getType() { return getClass().getSimpleName(); }
        int getvalue() { return ordinal()+4; }
    }
}

Flag f = Flag.A.one;