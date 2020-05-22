if (list.size() > 0) {
  Collections.sort(list, new Comparator<Car>() {
      @Override
      public int compare(final Car object1, final Car object2) {
          return object1.getRegNo().compareTo(object2.getRegNo());
      }
  });
}