class LengthComparator implements Comparator<ArrayList<Integer>> {
    public int compare(ArrayList<Integer> list1, ArrayList<Integer> list2) {
        return list2.size() - list1.size(); // sort descending in length
    }
}

// ...

ArrayList<ArrayList<Integer>> mainList;

// ... initialization, adding data

// sort
Collections.sort(mainList, new LengthComparator());