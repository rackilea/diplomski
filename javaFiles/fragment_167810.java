enum Google {
    Developer, Manager;

    public Builder builder(String name) {
        return new Builder(this, name);
    }

    public static class Builder {
        public Builder(Google role, String name) { ... }
        public Builder age(int age) { ... }
        public Employee build() { ... }
    }
}