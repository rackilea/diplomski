Disjunction or = Restrictions.disjunction();
for (BarEnum bar : BarEnum.values()) {
    if (bar.name().contains(matchStr)) {
        or.add(Restrictions.eq("bar", bar));
    }
}
criteria.add(or);