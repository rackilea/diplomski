for(Iterator<EmpDedup> iter = list.iterator(); iter.hasNext();) {
    EmpDedup data = iter.next();
    if (data.getRecord() == rec1) {
        iter.remove();
    }
}