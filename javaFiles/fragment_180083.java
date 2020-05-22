abstract class Item {
    public abstract void equip(Inventory inv);
}

class HelmItem extends Item {
    @Override
    public void equip(Inventory inv) {
        inv.setHelm(this);
    }
}

class WeaponItem extends Item {
    @Override
    public void equip(Inventory inv) {
        inv.setWeapon(this);
    }
}