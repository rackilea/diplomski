Collections.sort(Locations, new Comparator<Location>() {
        @Override
        public int compare(final Location object1, final Location object2) {
            return object1.name.compareTo(object2.name);
        }
    } 
);