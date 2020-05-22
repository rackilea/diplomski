GetListCollectionResult getListCollectionResult = listSoap.getListCollection();
Object result = getListCollectionResult.getContent().get(0);

if(result != null && result instanceof ElementNSImpl)
{
    Document document = ((ElementNSImpl)result).getOwnerDocument();
    System.out.println(WebServiceUtils.xml(document));
}