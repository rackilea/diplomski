Collections.sort(list, new Comparator<CustomObject>() {
            @Override
            public int compare(final CustomObject object1, final CustomObject object2) {
                return object1.v1 > object2.v1? -1 : object1.v1 < object2.v1 ? +1 : 0;
            }
        });