class Sports {
    private int id;
    private int value;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Sports sports = (Sports) o;
        return id == sports.id;
    }

    @Override
    public int hashCode() {    
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Sports{" +
                "id=" + id +
                ", value=" + value +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    Sports(int id, int value){
        this.id = id;
        this.value = value;
    }
}