listB.forEach(itemB -> map.merge(
            // key for our map
            itemB.getId(),
            // function to create new entry if no such key
            new DTO2(itemB.getId(), itemB.getUserLogin(), 0, itemB.getCount(),0),
            //function to update
            (existed, noMatter) -> {
                existed.setCountListB(itemB.getCount());
                return existed;
            }));