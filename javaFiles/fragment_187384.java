public class Spell implements Castable{
    private MagicalStructure magStruct;
    public setMagicalStruct(MagicalStructure magStruct) {
        this.magStruct = magStruct;
    }
    public Wizard getOwner() {
        return magStruct.owner;
    }
}