private WebMarkupContainer createContainer()
{
  final WeerService weerService = new WeerServiceImpl();

  PropertyListView<Weer> newview = new PropertyListView<Weer>("weer", weerService.getWeer()) 
  {

    @Override
    protected void populateItem(ListItem<Weer> item) 
    {
        item.add(new Label("temperatuur"));
        item.add(new StaticImage("type", String.format("images/%s.png", item.getModelObject().getType())));
        item.add(new Label("omschrijving"));
    }
  };

  WeerVoorspellingService weerVoorspellingService = new WeerVoorspellingServiceImpl();

  PropertyListView<WeerVoorspelling> hateView = new PropertyListView<WeerVoorspelling>("weersvoorspelling", weerVoorspellingService.getWeerVoorspelling()) 
  {

    @Override
    protected void populateItem(ListItem<WeerVoorspelling> item) 
    {
        item.add(new Label("dag"));
        item.add(new StaticImage("typeVoorspelling", String.format("images/%s.png", item.getModelObject().getType())));
        item.add(new Label("minTemperatuur"));
        item.add(new Label("maxTemperatuur"));
    }
  };

  WebMarkupContainer containerWeer = new WebMarkupContainer("containerWeer");
  containerWeer.setOutputMarkupId(true);
  containerWeer.add(hateView);
  containerWeer.add(newview);
  add(containerWeer);

  return containerWeer;
}