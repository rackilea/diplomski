public List<BigDecimal> CaptureCoeff() {
    getDegree();
    List<BigDecimal> Temp = new ArrayList<BigDecimal>();
    for (String S : C) {
        if (! "".equals(S.trim())) {
            Temp.add(new BigDecimal(S));
        }
    }