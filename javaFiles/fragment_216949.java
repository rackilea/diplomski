public void doIt(String s1, String s2, String s3){
    ...

    if (/*some s1 condition*/) {
        crit.add(Restrictions.eq("s1", s1));
    }

    if (/*some s2 condition*/) {
        crit.add(Restrictions.like("s2", s2 + "%"));
    }

    if (/*some s3 condition*/) {
        crit.add(Restrictions.ne("s3", s3));
    }

    return crit.list();
}