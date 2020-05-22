public SalesPersonComparator implements Comparator<salesPerson> {
    public int compare(final salesPerson p1, final salesPerson p2) {
        // get the comparison of the unit prices (in descending order, so compare p2 to p1)
        int comp = new Double(p2.getUnitPrice()).compareTo(new Double(p1.getUnitPrice()));

        // if the same
        if(comp == 0) {
            // compare the units sold (in descending order, so compare p2 to p1)
            comp = new Integer(p2.getUnitsSold()).compareTo(new Integer(p1.getUnitsSold()));
        }
        return comp;
    }
}