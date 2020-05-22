Country germany = new Country("Germany");
City berlin = new City("Berlin");
City Hamburg = new City("Hamburg");
berlin.country = germany;
hamburg.country = germany;
germany.cities = new HashSet<>(asList(berlin, hamburg));
germany.saveOrUpdate(); // or whichever definition you use