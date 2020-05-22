@Override
    public boolean equals(Object o) {
        if (null == o) return false;
        if (this.getClass() != o.getClass()) return false;

        Triangle t = (Triangle)o;
        List<Double> oSides = new ArrayList<Double>();
        oSides.add(t.side1);
        oSides.add(t.side2);
        oSides.add(t.side3);
        for (Double d : oSides) {
            if (d.equals(this.side1)) {
                oSides.remove(d);
                break;
            }
        }
        for (Double d : oSides) {
            if (d.equals(this.side2)) {
                oSides.remove(d);
                break;
            }
        }
        for (Double d : oSides) {
            if (d.equals(this.side3)) {
                oSides.remove(d);
                break;
            }
        }
        return oSides.isEmpty();
    }