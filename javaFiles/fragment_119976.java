Collections.min(dogList, new Comparator<Dog>() {

    @Override
    public int compare(Dog o1, Dog o2) {
        return o1.getBirthday().compareTo(o2.getBirthday()));
    }

}).getBirthday()