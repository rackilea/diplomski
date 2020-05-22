Map<Integer, List<String>> segList = new HashMap<Integer, List<String>>();
 Iterator<Entry<String, Integer>> i = citiesWithCodes.entrySet().iterator();
            while (i.hasNext()) {
                  Entry<String, Integer> next = i.next();
                  if (segList.get(next.getValue()) != null) {
                       List<String> city= segList.get(next.getValue());
                       city.add(next.getKey());
                       segList.put(next.getValue(), city);
                  }else{
                        List<String> city=new ArrayList<String>();
                        city.add(next.getKey());
                        segList.put(next.getValue(), city);

                  }
            }