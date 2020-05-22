PEPProvider pepProvider = new PEPProvider();
pepProvider.registerPEPParserExtension(
    "http://jabber.org/protocol/tune", new TuneProvider());
ProviderManager.getInstance().addExtensionProvider(
   "event", 
   "http://jabber.org/protocol/pubsub#event", pepProvider);
Tune tune = new Tune("jeff", "1", "CD", "My Title", "My Track");
pepManager.publish(tune);