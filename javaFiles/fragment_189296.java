enum Flag {
    A1, A2, A3, B4, B5, B6;
    public String getType() { return name().substring(0,1); }
    public int getValue() { return name().charAt(1) - '0'; }
}

Flag f = Flag.A1;