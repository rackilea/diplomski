private static final Comparator<String[]> comp = new Comparator<String[]>() {
    public int compare(String[] arg0, String[] arg1) {
        int length = arg0.length;
        if (arg1.length>arg0.length) length = arg1.length;

        for (int i=0; i<length; i++) {
            String s0 = null;
            if (i<arg0.length) s0 = arg0[i];
            Integer i0 = (s0==null)?0:Integer.parseInt(s0);
            String s1 = null;
            if (i<arg1.length) s1 = arg1[i];
            Integer i1 = (s1==null)?0:Integer.parseInt(s1);
            if (i0.compareTo(i1)<0) return -1;
            else if (i1.compareTo(i0)<0) return 1;
        }
        return 0;
    }
};