private static HashMap sortByComparator(HashMap unsortMap) {
            HashMap sortedMap = new LinkedHashMap();         
            try {       
                List list = new LinkedList(unsortMap.entrySet());

                // sort list based on comparator
                Collections.sort(list, new Comparator() {
                    public int compare(Object o1, Object o2) {
                        return ((Comparable) ((Map.Entry) (o1)).getValue())
                                .compareTo(((Map.Entry) (o2)).getValue());
                    }
                });

                // put sorted list into map again
                //LinkedHashMap make sure order in which keys were inserted

                for (Iterator it = list.iterator(); it.hasNext();) {
                    Map.Entry entry = (Map.Entry) it.next();
                    sortedMap.put(entry.getKey(), entry.getValue());
                }
            }
            catch(Exception e) {
                e.printStackTrace();
            }
            return sortedMap;
        }