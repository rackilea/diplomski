ArrayList< HashMap< String,String >> arrayList=populateArrayList();
    Collections.sort(arrayList, new Comparator<HashMap< String,String >>() {

        @Override
        public int compare(HashMap<String, String> lhs,
                HashMap<String, String> rhs) {
            // Do your comparison logic here and retrn accordingly.
            return 0;
        }
    });