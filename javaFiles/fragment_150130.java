// Column definition is not a necessity here
@Column(columnDefinition = "VARCHAR(40)")
private String foo;

public Double getFoo() {
    return this.foo != null ? Double.valueOf(this.foo) : null;
}

public void setFoo(Double d) {
    this.foo = d != null ? d.toString() : null;
}