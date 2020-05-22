if ((from == null) && (password != null)) {
    throw new IllegalArgumentException("If from is null, password must be null");
}
if ((from != null) && (password == null)) {
    throw new IllegalArgumentException("If from is not null, password must not be null");
}