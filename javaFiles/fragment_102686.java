class Character {
    int defensive, offensive, speed;

    Item weapon;
    Item armor;
    Item shoes;

    public int getTotalDefensive() {
        return armor.getDefensive() + defensive;
    }

    public int getTotalOffensive() {
        return weapon.getOffensive() + offensive;
    }

    public int getTotalSpeed() {
        return shoes.getSpeed() + speed;
    }

    public List<Attribute> getAttributes() {
        // if you really need to work with a character like this then you can do that too.
        List<Attribute> attributes = new ArrayList<Attribute>();
        attributes.add( new Attribute( "offensive", "How much damage you can do", offensive );
        attributes.add( new Attribute( "defensive", "How much damage you can sustain", defensive );
        attributes.add( new Attribute( "speed", "How fast you can move", offensive );
        return attributes;
    }
}