class CalculationModelDetailList extends ArrayList<CalculationModelDetail> {

    public List<CalculationModelDetail> sort() {
        Comparator<CalculationModelDetail> detailComparator = Comparator.comparing(
                CalculationModelDetail::getPriceRange,
                Comparator.nullsLast((s1, s2) -> s2.compareTo(s1)));
        Comparator<CalculationModelDetail> detailComparator_nullLast = Comparator
                .nullsLast(detailComparator);
        Collections.sort(this, detailComparator_nullLast);
        return this;
    }
}