private void update(){ 

    HashMap<String, List<StreamItem>> groupedHashMap = groupDataIntoHashMap(myOptions);


            for (String date : groupedHashMap.keySet()) {
                HeaderItem dateItem = new HeaderItem();
                dateItem.setDate(date);
                consolidatedList.add(dateItem);


                for (StreamItem pojoOfJsonArray : groupedHashMap.get(date)) {
                    EventItem generalItem = new EventItem();
                    generalItem.setStreamItem(pojoOfJsonArray);//setBookingDataTabs(bookingDataTabs);
                    consolidatedList.add(generalItem);
                }
            }

            adapter = new StreamArrayAdapter(this, consolidatedList);
            LinearLayoutManager layoutManager = new LinearLayoutManager(this);
            layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
            mRecyclerView.setLayoutManager(layoutManager);
            mRecyclerView.setAdapter(adapter);}