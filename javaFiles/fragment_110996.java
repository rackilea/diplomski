private Comparator<Country> sorter;

public CountryComponent(Comparator<Country> sorter) throws IOException {
    this.sorter = sorter;
    getData(); 
    Collections.sort(countriesList, sorter);
}