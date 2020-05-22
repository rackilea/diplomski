public Long getTotal() {
    if (total == null) {
        total = val1 + val2;
    }
    return total;
}

public void setVal1(Long val1) {
    this.val1 = val1;
    this.total = null;
}

public void setVal2(Long val2) {
    this.val2 = val2;
    this.total = null;
}