List<Long> repeatedLateComersId=new ArrayList<Long>();
    for (Customer lateComer: lateComers) {
        if (Collections.frequency(lateComers, lateComer) > 3) {
            repeatedLateComersId.add(lateComer.getId());
        }
    }