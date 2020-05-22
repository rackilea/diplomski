final public Polynomial composite(Polynomial that) {
    if (that==null) return null;
    Polynomial thisClone = this.clone();
    Polynomial thatClone = that.clone();
    Polynomial temp = new Polynomial(0.0,0);
    Polynomial result = new Polynomial(0.0,0);

    while(thisClone != null) {
        System.out.println("composite with term degree: " + thisClone.power);
        if (thisClone.power == 0) {
            temp.coefficient = 1.0;
            temp.power = 0;
        } else if (thisClone.power == 1) {
            temp = thatClone;
        } else {
            for(int i=2; i<=thisClone.power; i++) {
                temp = temp.plus(thatClone.times(thatClone));
            }
        }
        System.out.println("temp heading in: " + temp);

        while(temp != null) {
            temp.coefficient = thisClone.coefficient*temp.coefficient;
            result = result.plus(temp);
            temp = temp.successor;
        }
        System.out.println("result so far: " + result);
        temp = new Polynomial(0.0,0);
        thisClone=thisClone.successor;
    }
    return result;
}