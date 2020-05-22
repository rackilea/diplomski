public List<Term> getFilteredRowNum(List<Term> termList1, List<Term> termList2) {
    return termList1.stream()
            .filter(term1 -> termList2.stream()
                    .anyMatch(term2 -> term1.getSId() == term2.getSId()
                            && term1.getPsid() != term2.getPsid()))
            .collect(Collectors.toList());
}