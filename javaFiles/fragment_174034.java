StringBuilder dump() {
    StringBulder sb = new StringBuilder();
    for (Foo child : children) {
        sb.append(child.dump()); // Inefficient
    }
    return sb;
}