LinkedList<TreeItem<TimeDataRecords>> entrys = new LinkedList<>();

for(TimeDataRecords entry : timeDataRecsMap.values()){
    TreeItem<TimeDataRecords> node = new TreeItem<TimeDataRecords>(entry);

    if(entry.isProject()) entrys.addFirst(node);
    else entrys.addLast(node); 
}

root.getChildren().addAll(entrys);