Container container = queryList.getContainerDataSource();
container.removAllItems();
List<String> queries = getQueryList();
for(String query : queries) {
    container.addItem(query);
}