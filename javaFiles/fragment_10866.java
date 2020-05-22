public static class FilterComparator implements Comparator<TestObj> {

        public  int compare(TestObj o1, TestObj o2) {
            if (compareIfSameString(o1.getField1(), o2.getField1()) //
                    && compareIfSameString(o1.getField2(), o2.getField2()) //
            ) {
                return 1;// here
            }

            return 0; //and here
        }
    }