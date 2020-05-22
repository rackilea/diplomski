boolean hi;
boolean bye;

void setTrue(String name) {
    try {
        this.getClass().getField(name).set(this,Boolean.TRUE);
    } catch (Throwable e) { }

}