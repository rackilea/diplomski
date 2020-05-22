private boolean negate = false;

public Builder not() {
    negate = true;
}

public Builder username(final String username) {
    this.usernameConstraint = new Constraint<>(Operation.IS, !negate, username, "username");
    negate = false;
    return this;
}