List<Class<? extends Number>> list = new ArrayList<>();
...//Add stuff
List<Number> randoms = p.click(myString, myElement, list);

List<Class<? extends Page>> pages = new ArrayList<>();
...//Get the breadcrumbs
List<Page> crumbs = p.click(myString, myElement, pages);