interface CatalogFactory {
    public ICatalog makeCatalog();
}

class DocumentServiceFactory implements CatalogFactory {
    @Override
    public ICatalog makeCatalog() {
        return new DocumentService();
    }
}

class TabAction extends AbstractAction {
    private final String name;
    private final CatalogFactory factory;

    //Appropriate constructor...

    @Override
    public void actionPerformed(ActionEvent e) {
        //...
        newCatalogTab(factory.makeCatalog(), name);
        //...
    }
}