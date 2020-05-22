private static MyObject self = null;

public MyObject() {
    this.active = false;
    if (self == null) { // prevents Gson from messing with it later on
        self = this;
    }
}