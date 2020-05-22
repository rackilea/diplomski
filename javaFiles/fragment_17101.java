interface AmmoHolder {
    getMax();
    get/setCur(); // consume or reload
    getShootable();
    getCap();
}

class BasicTurret(AmmoHolder primary, AmmoHolder secondary) {
    this.primaryAmmo = primary;
    this.secondaryAmmo = secondary;
}