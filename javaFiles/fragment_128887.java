PicoContainer container = new DefaultPicoContainer();
container.addComponent(Earth.class);
container.addComponent(Continent.class);
container.addComponent(Country.class);
container.addComponent(City.class, new ConstantParameter(cityName));

City barcelona = container.getComponent(City.class);