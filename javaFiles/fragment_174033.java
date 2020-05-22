void dump(StringBuilder sb) {
    sb.append(name);
    for (Foo child : children) {
        child.dump(sb);
    }
}