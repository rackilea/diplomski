HashMap<String, ItemsData> map = response .data;
            Set<String> s = map.keySet();
            Iterator<String> i = s.iterator();
            while (i.hasNext()){
                String key = i.next();
                ItemsData data = map.get(key);
                String id = data.id;
                String name = data.name;
                String address = data.address;
                String category = data.category;
                String open24Hr = data.open_24_hours;
                String businessOpen = data.business_open;
                String close = data.business_close;
                String latitue = data.latitude;
                ..... etc

            }