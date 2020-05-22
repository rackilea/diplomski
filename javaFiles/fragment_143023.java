if(graphData != null){
            for(Map<Integer, Integer> valueMap : graphData){
                for (Map.Entry<Integer, Integer> entry : valueMap.entrySet()) {
                    if (entry.getValue() > largest)
                        largest = entry.getValue();
                    bars++;
                }
            }
        }