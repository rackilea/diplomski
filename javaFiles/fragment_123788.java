public static Map<Integer, PolovniAutomobili> automobil = new HashMap<>();
static {

    automobil.put(1, new PolovniAutomobili(1, 2012, "Polo", "Volkswagen", 75.00));
    automobil.put(2, new PolovniAutomobili(2, 2018, "Arteon", "Volkswagen", 155.00));
    automobil.put(3, new PolovniAutomobili(3, 2006, "Clio", "Renault", 55.00));
    automobil.put(4, new PolovniAutomobili(4, 2011, "Punto", "Fiat", 60.00));
    automobil.put(5, new PolovniAutomobili(5, 2010, "Spark", "Chevrollete", 65.00));

}

public List<PolovniAutomobili> findAll() {
    return automobil.values();
}

public PolovniAutomobili findOne(int id) {
    // if id is not a ky, it will return null (you can manage it)
    return automobil.get(id);
}

public void addAutomobil(PolovniAutomobili polovniAutomobili) {
    automobil.put(polovniAutomobili.getId(), polovniAutomobili);
}

public void deleteAutomobil(int id) { 
    if(automobil.containsKey(id))
        automobil.remove(id);
    else
        System.out.println("Id not found");
}