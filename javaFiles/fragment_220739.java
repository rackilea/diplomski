@Override
public boolean equals(Object obj) {
    if (!obj instanceof Variable) {
        return false;
    }
    return this.variable.equals(((Variable) obj).getVariable());
}