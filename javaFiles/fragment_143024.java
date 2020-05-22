if(graphData != null){
        for(Map<Integer, Integer> valueMap : graphData){
            for (Integer value : valueMap.values()) {
                if (value > largest)
                    largest = value;
                bars++;
            }
        }
    }