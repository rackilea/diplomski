public boolean equals(Object o) {
    if (this== o) return true;
    if (o ==null|| getClass() != o.getClass()) return false;

    GaraAgenziaId that = (GaraAgenziaId) o;

    if (gara !=null?!gara.equals(that.gara) : that.gara !=null) return false;
    if (agenzia !=null?!agenzia.equals(that.agenzia) : that.agenzia !=null)
        return false;

    return true;
}

public int hashCode() {
    int result;
    result = (agenzia !=null? agenzia.hashCode() : 0);
    result =31* result + (gara !=null? gara.hashCode() : 0);
    return result;
}