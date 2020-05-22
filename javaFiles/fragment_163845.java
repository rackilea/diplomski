Collections.sort(unsortedList,new CustomComparator(sortedList));

public class CustomComparator implements Comparator<String>{
        private List<String> sortedList;
        public CustomComparator(List<String> sortedList){
            this.sortedList = sortedList;
        }

        @Override
        public int compare(String o1, String o2) {
            return sortedList.indexOf(o1)-sortedList.indexOf(o2);
        }       
    }