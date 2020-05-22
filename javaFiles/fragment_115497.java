objectList.stream().sorted((h1, h2) -> {
        ObjDate h1date;
        ObjDate h2date;

        if (h1.getObjectType().getId() == 1) {
            h1date = h1.getObject().getTable1().getTime();
        } else {
            h1date = h1.getObject().getTable2().getTime();
        }

        if (h2.getObjectType().getId() == 1) {
            h2date = h2.getObject().getTable1().getTime();
        } else {
            h2date = h2.getObject().getTable2().getTime();
        }

        return h1date.compareTo(h2date);
    });