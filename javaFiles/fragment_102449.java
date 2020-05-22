Iterator<Map.Entry<String, Shipment>> iterator = shipMap.entrySet().iterator();
            while(iterator.hasNext()){

                   // Get the Entry from your Map and get the value from the Entry
                   Entry<String, Shipment> entry = iterator.next();
                   List<Integer> metricList = entry.getValue().getList();

                   Iterator<String> metricIterator = metricList.iterator();

                   //Above is the Array List I want to access and loop through
                   //I will then perform certain checked against other values on a table...

                    while (metricIterator.hasNext()) {
                    //I will perform certain things here
                    }
            }