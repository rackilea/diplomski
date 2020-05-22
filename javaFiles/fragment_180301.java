public DataObjectComparator extends Comparator<DataObject> {
    public int compare(DataObject o1, DataObject o2) {
        // if the age is the same
        if(o1.age == o2.age) {
            // if the hair colour is the same
            if(o1.hairColour.compareTo(o2.hairColour) == 0) {
                // return the name comparison
                return o1.name.compareTo(o2.name);
            } else {  // else return the hair colour comparison
                return o1.hairColour.compareTo(o2.hairColour);
            }
        } else {  // else return the age comparison
            return o1 < o2 ? -1 : 1;
        }
    }
}