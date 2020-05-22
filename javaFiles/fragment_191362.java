private <T extends View & Checkable> T get() {
   return (T) mView;
}

private <T extends View & Checkable> void useGeneric() {
    View v = this.get(); // no need for an explicit type
    Checkable c = this.<T>get(); // an explicit type needed
    T t = this.get(); // best way
}

private void useSpecific() {
    class Specific extends View implements Checkable {}
    Checkable c = this.<Specific>get(); // risk of ClassCastException
    Specific s = this.get(); // best way; risk of ClassCastException
}