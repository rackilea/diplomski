Collections.sort(Arrays.asList(carList), new Comparator<Car>() {
            @Override
            public int compare(Car o1, Car o2) {
                return Float.compare(o2.myDistance(), o1.myDistance());
            }
        });