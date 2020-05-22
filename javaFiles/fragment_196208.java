class Apple extends Fruit {
    private AppleVariety appleVariety;

    @Override
    public String toString() {
        String description = super.toString();
        description += "\nApple variety: " + appleVariety;
        return description;
    }
 }