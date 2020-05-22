List<Rec_Items> sortedList = new ArrayList();
if (list.size() > 0) {
    Collections.sort(list, new Comparator<Rec_Items>() {
        @Override
        public int compare(final Rec_Items object1, final Rec_Items object2) {
            return object1.getProfession().compareTo(object2.getProfession());
        }
    });
}

//                                  SORTED LIST
Adapter adapter = new Adapter(this, sortedList);