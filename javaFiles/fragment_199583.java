while(keysItr.hasNext()) {
                String key = keysItr.next();
                JSONArray jlist = jsonObject.getJSONArray(key);
                List<Integer> list = new ArrayList<>();
                for(int i=0; i < jlist.length(); i++){
                    list.add(jlist.getInt(i));
                }
                outputMap.put(key, list);
            }