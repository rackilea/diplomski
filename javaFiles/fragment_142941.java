DeclaredType theBinder = lookup("android.os.Binder");
DeclaredType theIInterface = lookup("android.os.IInterface");
DeclaredType theCreator = lookup("android.os.Parcelable.Creator");
...
private DeclaredType lookup(CharSequence name) {
    return types.getDeclaredType(elements.getTypeElement(name));
}