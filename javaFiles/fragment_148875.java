enum Starters {
    SPRING_ROLLS("Spring Rolls", "Rs 350", 5),
    FRIED_RAVIOLLI("Fried Raviolli", "Rs 400", 9),
    ... // All other starters...

    String name;
    String code;
    int price;

    public Starters(String name, String code, String price) {
        this.name = name;
        this.code = code;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public String getCode(){
        return code;
    }

    public int getPrice(){
        return price;
    }
}