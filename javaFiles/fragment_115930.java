public static Map<String, Object>[] getArrayData(List<Map<String, Object>> list){
        @SuppressWarnings("unchecked")
        Map<String, Object>[] maps = new HashMap[list.size()];

        Iterator<Map<String, Object>> iterator = list.iterator();
        int i = 0;
        while (iterator.hasNext()) {
            Map<java.lang.String, java.lang.Object> map = (Map<java.lang.String, java.lang.Object>) iterator
                    .next();
            maps[i++] = map;
        }

        return maps;
    }