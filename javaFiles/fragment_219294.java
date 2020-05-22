@Override
public int hashCode() {
    int hash = 5;
    hash = 79 * hash + Objects.hashCode(this.date);
    hash = 79 * hash + this.part_journee;
    hash = 79 * hash + Objects.hashCode(this.part_journee_v);
    return hash;
}

@Override
public boolean equals(Object obj) {
    if (obj == null) {
        return false;
    }
    if (getClass() != obj.getClass()) {
        return false;
    }
    final TrancheHoraire other = (TrancheHoraire) obj;
    if (!Objects.equals(this.date, other.date)) {
        return false;
    }
    if (this.part_journee != other.part_journee) {
        return false;
    }
    if (!Objects.equals(this.part_journee_v, other.part_journee_v)) {
        return false;
    }
    return true;
}