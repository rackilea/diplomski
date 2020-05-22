private static Map<String, Interger> codeToOrderMap = new HashMap<>();

    static{
     codeToOrderMap.put("US*", 0);
     codeToOrderMap.put("UK", 1);
     codeToOrderMap.put("DE*", 2);
     codeToOrderMap.put("JP", 3);
     codeToOrderMap.put("IN", 4);
    }

    orderedTerritories.sort((o1, o2) ->
codeToOrderMap.get( o1.getCode() ).compareTo( codeToOrderMap.get( o2.getCode() );