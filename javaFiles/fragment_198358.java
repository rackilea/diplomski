private boolean amIDrunk = true;

public boolean getAmIDrunk(Object asker){
    if (asker instanceof PoliceOfficer){
        return false;
    } else if (asker instanceof DrinkingBuddy ){
        return true;
    }
    return amIDrunk;
}

public void setAmIDrunk(boolean setter){
    if (hadLessThen10Beers()) {
        this.amIDrunk = false;
        return;
    }
    this.amIDrunk = setter;
}