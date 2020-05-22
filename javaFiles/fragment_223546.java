class MixAndMatchComparator implements Comparator<Task> {

        List<Comparator<Task>> comparators;

        public MixAndMatchComparator(List<Comparator<Task>> comparators) {
            this.comparators=comparators;
        }

        @Override
        public int compare(Task o1, Task o2) {
            int compareResult = 0;
            for(Comparator<Task> comparator : comparators) {
                if(comparator.compare(o1, o2)!=0) {
                    return comparator.compare(o1, o2);
                }
            }
            return compareResult;
        }

    }