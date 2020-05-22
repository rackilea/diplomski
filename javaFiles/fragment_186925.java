public enum ArmorType
{
    SHIELD(){
        public ItemSlot getArmorSlot(Equipment equipment){
            return equipment.offHand;
        } 
    },
    ...

    public abstract ItemSlot getArmorSlot(Equipment equipment);
}