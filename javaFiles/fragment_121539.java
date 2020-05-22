@FindBy(xpath="//div[@class='sh-dlr__list-result']")
private List<WebElement> SearchResult;

public List<WebElement> getSearchResult() {
    return SearchResult;
}