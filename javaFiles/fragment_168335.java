+-------- HashMap<String, String> map = new HashMap<String, String>();
   |
   |            for (int i = 0; i < dealList.size(); i++) {
   +--------------->  
                    map.put(DealItem.DEAL_ID, dealList.get(i).deal_id);
                    map.put(DealItem.DEAL_NAME, dealList.get(i).deal_name);
                    System.out.println("DEAL NAME = "+dealList.get(i).deal_name);
                    placesListItems.add(map);

                }