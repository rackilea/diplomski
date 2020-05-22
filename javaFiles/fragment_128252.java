while (!(list.contains("NORTH SOUTH") || list.contains("SOUTH NORTH") || list.contains("WEST EAST") || list.contains("EAST WEST"))) {

    boolean conditionChecker=false;
    for (int i = 0; i < list.size(); i++) {
        for (int k = i + 1; k < list.size(); k++) {
            if (list.get(i).contains("NORTH") && list.get(k).contains("SOUTH") ||
                list.get(i).contains("SOUTH") && list.get(k).contains("NORTH") ||
                list.get(i).contains("WEST") && list.get(k).contains("EAST") ||
                list.get(i).contains("EAST") && list.get(k).contains("WEST")) {
                list.remove(i);
                list.remove(k - 1);
                conditionChecker=true;
                break;

              }
        }
        if(conditionChecker==true){
          break;      
           }
    }