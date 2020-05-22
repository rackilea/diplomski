elements = findDynamicElements("//a[@class='name']");
int size = elements.size();
for (int i = 0 ; i < size ; ++i) {
    elements = findDynamicElements("//a[@class='name']");
    userName = elements.get(i).getText();
    check_visitor_profile(userName);
}