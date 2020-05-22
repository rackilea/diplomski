// the classed to load
Class[] classes = {
    Boils.class,
    Cystitis.class,
    Asthma.class,
    Feet.class
};

for (int i = 0; i < herb_names.length; i++) {
    Home home = new Home(i, herb_names[i], herb_pics.getResourceId(i, -1), classes[i]);
    homelist.add(home);
}