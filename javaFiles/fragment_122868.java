public class RemoteWebElementWrapper extends RemoteWebElement {

    private final RemoteWebElement instance;
    public RemoteWebElementWrapper(RemoteWebElement instance) {
        super();
        this.instance = instance;
    }
@Override
List<WebElement> findElementsByLinkText(String using){
return instance.findElementsByLinkText(using)
}
@Override
List<WebElement> findElementsByName(String using){
instance.findElementsByName(using)
}
@Override
List<WebElement>    findElementsByPartialLinkText(String using){
instance.findElementsByPartialLinkText(using)
}
//etc
}