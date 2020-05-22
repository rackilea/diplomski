MapProperty<String, Object> master = new SimpleMapProperty<String, Object>(
        FXCollections.observableMap(new HashMap<String, Object>()));
MapProperty<String, Object> child = new SimpleMapProperty<String, Object>(
        FXCollections.observableMap(new HashMap<String, Object>()));

ObservableMap<String, Object> childMap = child.get();
ObservableMap<String, Object> masterMap = master.get();

System.out.println("before binding: " + ((childMap == masterMap) ? "childMap == masterMap" : "childMap != masterMap"));

child.bind(master);

childMap = child.get();
masterMap = master.get();

System.out.println("after binding: " + ((childMap == masterMap) ? "childMap == masterMap" : "childMap != masterMap"));

child.unbind();
System.out.println("after unbinding: " + ((childMap == masterMap) ? "childMap == masterMap" : "childMap != masterMap"));