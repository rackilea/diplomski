public Scheme join(final Scheme other) {
    final HashSet<Attribute> $ = new HashSet<Attribute>();

    for (Attribute attr : attributes) {
        $.add(attr);
    }

    for (Attribute attr : other.attributes) {
        $.add(attr);
    }

    return new Scheme(true, $.toArray(new Attribute[$.size()]));
}