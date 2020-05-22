private List<Country> countries;

@PostConstruct
public void init() {
    countries = myDao.getCountryList();
}

public List<Country> getCountries() {
    return countries;
}