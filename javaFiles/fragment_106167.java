Disjunction disjunction = Restrictions.disjunction();
for (XYZ xyz : xyzs) {
    ...
    disjunction.add(Restrictions.between("dob", maxAge, minAge));
}
criteria.add(disjunction);