class WrapperEmployee {
    private Employee e;

    public WrapperEmployee(Employee e) {
        this.e = e;
    }

    public Employee unwrap() {
        return this.e;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WrapperEmployee that = (WrapperEmployee) o;
        return Objects.equals(e.getId(), that.e.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(e.getId());
    }
}