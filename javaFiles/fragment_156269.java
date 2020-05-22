void printData(DataSnapshot data) {
        System.out.println(data.getName() + ":" + data.getValue());
        if (data.hasChildren()) {
            Iterator<DataSnapshot> it = data.getChildren().iterator();
            while (it.hasNext()) {
                DataSnapshot dataSnapshot = (DataSnapshot) it.next();
                printData(dataSnapshot);
            }
        }
    }