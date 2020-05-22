Predicate p = cb.conjunction();
if(companyCod != null) {
    p = cb.and(p, cb.equal(desembolso.get("codigo"), companyCod));
}
if (estado != null) {
    p = cb.and(p, cb.equal(desembolso.get("estadoImportacion"), estado));
}