@Override
public boolean equals(Object obj) {
    if (obj instanceof SomeBean) {
        SomeBean other = (SomeBean) obj;
        return new EqualsBuilder()
                .append(foo, other.foo)
                .append(bar, other.bar)
                .append(baz, other.baz)
                .isEquals();
    }
    return false;
}