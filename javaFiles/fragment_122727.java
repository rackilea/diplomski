public boolean equals(Object o) {
        if (this== o) return true;
        if (o ==null|| getClass() != o.getClass()) return false;

        GaraAgenzia that = (GaraAgenzia) o;

        if (getPk() !=null?!getPk().equals(that.getPk()) : that.getPk() !=null) return false;

        return true;
    }

    public int hashCode() {
        return (getPk() !=null? getPk().hashCode() : 0);
    }