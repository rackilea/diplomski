String priority = ...;

List<String> list = data.get(priority);
list.add("my new data");

if (list.size() == 1) {
  //insert tab
  int index = 0;
  int priorityIndex = priorities.indexOf(priority);
  while (priorityIndex > priorities.indexOf(tabbedPaned.getTitleAt(index))) {
    index++;
  }
  tabbedPane.insertTab(priority, ... , index); //includes index where to insert the tab
}

//update tabs
...