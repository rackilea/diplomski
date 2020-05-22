@Override
    public Enumeration getHeaders(String name) {
        Enumeration e = super.getHeaders(name);
        if (e != null && e.hasMoreElements()) {
            return e;
        } else {
            List l = new ArrayList();
            if (headerMap.get(name) != null) {
                l.add(headerMap.get(name));
            }
            return Collections.enumeration(l);
        }
    }