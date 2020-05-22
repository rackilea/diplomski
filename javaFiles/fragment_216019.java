if (item.getDestination() instanceof PDPageDestination)
{
    PDPageDestination pd = (PDPageDestination) item.getDestination();
    System.out.println("Destination page: " + (pd.retrievePageNumber() + 1));
}
else if (item.getDestination() instanceof PDNamedDestination)
{
    PDPageDestination pd = document.getDocumentCatalog().findNamedDestinationPage((PDNamedDestination) item.getDestination());
    if (pd != null)
    {
        System.out.println("Destination page: " + (pd.retrievePageNumber() + 1));
    }
}

if (item.getAction() instanceof PDActionGoTo)
{
    PDActionGoTo gta = (PDActionGoTo) item.getAction();
    if (gta.getDestination() instanceof PDPageDestination)
    {
        PDPageDestination pd = (PDPageDestination) gta.getDestination();
        System.out.println("Destination page: " + (pd.retrievePageNumber() + 1));
    }
    else if (gta.getDestination() instanceof PDNamedDestination)
    {
        PDPageDestination pd = document.getDocumentCatalog().findNamedDestinationPage((PDNamedDestination) gta.getDestination());
        if (pd != null)
        {
            System.out.println("Destination page: " + (pd.retrievePageNumber() + 1));
        }
    }
}