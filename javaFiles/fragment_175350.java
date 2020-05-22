public Tail getTail(long value1, String value2, int value3) {
        List<Tail> l = --> (I get list via Hibernate.)
        if (l.size() == 1) {
            return (Tail) l.get(0);
        } else if (l.size()>1){
            for (Tail t: l) {
                First ik = minorDAO.getFirst(value3, t.getNumber());
                if( ik.getCond().equals("I") ){
                    t.setCond("I");
                    continue;
                } else {
                    return t;
                }   
            }

        }
        return null;

    }