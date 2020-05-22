ArrayList<Map<String, Object>> data = new ArrayList<Map<String, Object>>(NUMBER_OF_SHOWING_USERS);
    for(int i=0;i< NUMBER_OF_SHOWING_USERS; i++) {
        HashMap<String, Object> m = new HashMap<String, Object>();
        m.put(ATTRIBUTE_NAME_TEXT_NAME, FriendNames.get(i));
        m.put(ATTRIBUTE_NAME_TEXT_RAITING, PointsList.get(i));
        m.put(ATTRIBUTE_NAME_IMAGE, PhotoAsBytesList.get(i));
        data.add(m);
    }
    // Sorting on user rating
    Collections.sort(data, new Comparator<Map<String, Object>>() {
        @Override
        public int compare(Map<String, Object> o1, Map<String, Object> o2) {
            Integer r1 = (Integer)o1.get(ATTRIBUTE_NAME_TEXT_RAITING);
            Integer r2 = (Integer)o2.get(ATTRIBUTE_NAME_TEXT_RAITING);
            return r1.compareTo(r2);
        }
    });