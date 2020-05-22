public PoundsOunces add(PoundsOunces object2) {
    PoundsOunces pounces = new PoundsOunces();
    pounces.pounds =this.pounds + object2.pounds; 
    pounces.ounces = this.ounces+ object2.ounces;
    return pounces;
}