enum Mobile {
    Samsung(400), Nokia(250),Motorola(325);

    private static final Map<Integer, Mobile> MOBILES = new HashMap<>();
    static {
        for (Mobile m : values())
            MOBILES.put(m.price, m);
    }

    int price;

    Mobile(int p) {
        price = p;
    }

    int showPrice() {
        return price;
    }

    public static Mobile byValue(int value) {
        return MOBILES.get(value);
    }
}