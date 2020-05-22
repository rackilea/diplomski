...

public void setName(String name) {
    this.name = name;
    nameContainsDash = name.contains("-");
}

public boolean isNameContainsDash() {
    return nameContainsDash;
}

...