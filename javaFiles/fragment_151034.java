public class MyComparableByDateAdded implements Comparator<fileOjb>{

    @Override
    public int compare(fileOjb o1, fileOjb o2) {
        return (o1.dateAdd>o2.dateAdd ? -1 : (o1.dateAdd==o2.dateAdd ? 0 : 1));
    }
}

Collections.sort(list, new MyComparableByDateAdded());