public Record(Record r) {
    this(r.day, r.name, r.name, r.category, r.amount);
}

public Record merge(Record r) {
    this.amount += r.amount;
    return this;
}