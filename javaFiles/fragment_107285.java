for (UserPoint up : hashMap.get(id)) {

        double upDistance = up.getDistance();

        if (upDistance == 0) {
            String pName = up.getPointName();


                if (!(arrayList.contains(pName))) {
                    arrayList.add(pName);

                    incrementCounter += 1;
                }
        }