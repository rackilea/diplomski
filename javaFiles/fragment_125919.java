T v = list.get(lt);
    for (int ix = lo; ix < lt; ix++) {
        assert comparator.compare(list.get(ix), v) < 0 : "lt " + lt + ' ' + list;
    }
    for (int ix = lt; ix <= gt; ix++) {
        assert comparator.compare(list.get(ix), v) == 0 : "lt " + lt + " gt " + gt + ' ' + list;
    }
    for (int ix = gt + 1; ix <= hi; ix++) {
        assert comparator.compare(list.get(ix), v) > 0 : "gt " + gt + ' ' + list;
    }