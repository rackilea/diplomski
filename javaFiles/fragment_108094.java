List<BaseEntry> result = new ArrayList<BaseEntry>();
    Iterator it =  session()
    .createQuery("select b, (select count(p.id) as depth from BaseEntry p " +
            "   where ... ) as d" +
            " from BaseEntry b " +
            " where ... ")
    .list().iterator();
    while ( it.hasNext() ) {
        Object[] row = (Object[]) it.next();
        BaseEntry entry = (BaseEntry) row[0];
        Long d = (Long) row[1];
        entry.setD(d);
        result.add(entry);
    }
    return result;