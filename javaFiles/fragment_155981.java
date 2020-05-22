Map<String, String> result = new LinkedHashMap<String, String>(parameterMap.size());
            for (Map.Entry<String, String[]> entry : parameterMap.entrySet()) {
                if (entry.getValue().length > 0) {
                    result.put(entry.getKey(), entry.getValue()[0]);
                }
            }

Set<String> nameSet = result.keySet();
String[] namesHolder= new String[nameSet.size()];
nameSet.toArray(namesHolder);