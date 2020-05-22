String tabTitle = "tab title";
Node tabContent = ...; // tab content goes here
int index = ...; // index for new tab

Tab tab = new Tab(tabTitle, tabContent);
tabPane.getTabs().add(index, tab);