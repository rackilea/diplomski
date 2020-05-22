public static boolean checkValueExists(Map<String, Object> eMap, String searchedValue){
            for (Map.Entry<String, Object> item : eMap.entrySet()) {
                String key = item.getKey();
                Set<String> setValue = (Set<String>) item.getValue();

                if(setValue.contains(searchedValue)){
                    return true;
                }

            }
            return false;
        }