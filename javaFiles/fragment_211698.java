@Override
public boolean equals(Object o) {
    if (o == null) {
        return false;
    }
    if (!(o instanceof SalePerson)) {
        return false;
    }
    return Integer.compare(Integer.compare(this.totalSales, o.getTotalSales())) == 0
            && this.lastName.equals(o.getLastName());
}

@Override
public int hashCode() {
    return this.lastName.hashCode() * 31 + this.totalSales;
}