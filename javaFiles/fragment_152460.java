public List<String> parqueListFilters = new ArrayList<String>() ;

public String getParqueListFilter() {
    return parqueListFilter;
}

public void setParqueListFilter(String parqueListFilter) {
    this.parqueListFilter = parqueListFilter;
    parqueListFilters.add(parqueListFilter);
}