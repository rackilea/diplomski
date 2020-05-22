@Override
    public int hashCode() {
        return Objects.hash(getAttrib1(), getAttrib2(), getAttrib3(),
            // …
                            getAttrib19(), getAttrib20());
    }

    @Override
    public boolean equals(Object obj) {
        if(this==obj) return true;
        if(!(obj instanceof Parent)) return false;
        Parent p=(Parent) obj;
        return Objects.equals(getAttrib1(), p.getAttrib1())
            && Objects.equals(getAttrib2(), p.getAttrib2())
            && Objects.equals(getAttrib3(), p.getAttrib3())
            // …
            && Objects.equals(getAttrib19(), p.getAttrib19())
            && Objects.equals(getAttrib20(), p.getAttrib20());
    }