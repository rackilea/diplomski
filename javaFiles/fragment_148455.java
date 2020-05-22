@Override
public int compareTo(Object o) {
    Patient p = (Patient) o;
    if (this.getCategory() < p.getCategory())
        return -1;
    if (this.getCategory() > p.getCategory())
        return 1;
    else { if (this.getTimeArrived().before(p.getTimeArrived()))
        return -1;
        if (this.getTimeArrived().after(p.getTimeArrived()))
           return 1;
    }
    return 0;
}