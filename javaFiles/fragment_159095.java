public static void main(String[] args) throws IOException {

        List<Map> listGrid = new ArrayList<Map>();

        Map<String, Object> resultMap = new HashMap<String, Object>();
        resultMap.put("id", "5");
        resultMap.put("name", "person");
        resultMap.put("no", 9);
        listGrid.add(resultMap);
        resultMap = new HashMap<String, Object>();
        resultMap.put("id", "6");
        resultMap.put("name", "person");
        resultMap.put("no", 19);
        listGrid.add(resultMap);
        resultMap = new HashMap<String, Object>();
        resultMap.put("id", "6");
        resultMap.put("name", "jam");
        resultMap.put("no", 21);
        listGrid.add(resultMap);
        resultMap = new HashMap<String, Object>();
        resultMap.put("id", "6");
        resultMap.put("name", "jam");
        resultMap.put("no", 21);
        listGrid.add(resultMap);
        List<Map> destListGrid = new ArrayList<Map>();
        HashMap<String, Object> destMap = new HashMap<String, Object>();

        ListIterator litr = listGrid.listIterator();
        while (litr.hasNext()) {

            HashMap<String, Object> element = (HashMap<String, Object>) litr
                    .next();
            String id = (String) element.get("id");
            Integer damagesNo = (Integer) element.get("no");
            if (destMap.containsKey(id)) {
                Integer mapCode = (Integer) destMap.get(id);
                if (mapCode <= damagesNo) {
                    destMap.remove(id);
                    destMap.put(id, damagesNo);
                }
            } else {
                destMap.put(id, damagesNo);
            }
        }

        for (Map map : listGrid) {

            if (destMap.containsKey(map.get("id"))
                    && destMap.get(map.get("id")) == map.get("no")) {
                            destMap.remove(map.get("id"));  
                destListGrid.add(map);
            }
        }

        System.out.println(destListGrid);
    }