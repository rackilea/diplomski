public TypeVariable<?> lookup(String name) {
    TypeVariable<?>[] tas = getRecvr().getTypeParameters();
    for (TypeVariable<?> tv : tas) {
        if (tv.getName().equals(name)) {return tv;}
    }
    return getEnclosingScope().lookup(name);
}