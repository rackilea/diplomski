@Override
public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Veicolo veicolo = (Veicolo) o;
    return targa.equals(veicolo.getTarga());
}

@Override
public int hashCode() {
    final int PRIME = 31;
    int result = 1;
    result = PRIME * result + getTarga().hashCode();
    return result;
}