ExchangeService service = new ExchangeService(ExchangeVersion.Exchange2007_SP1);
ExchangeCredentials credentials = new WebCredentials(userName, password);
service.setCredentials(credentials);
service.autodiscoverUrl(autoDiscoverUrl);
service.setTraceEnabled(true);

ItemView view = new ItemView(20);
FindItemsResults<Item> findResults;
do {
      findResults = service.findItems(WellKnownFolderName.RecoverableItemsDeletions, view);
      for (Item item : findResults.getItems()) {
        System.out.println(item);
      }
      view.setOffset(view.getOffset() + 20);
   } while (findResults.isMoreAvailable());