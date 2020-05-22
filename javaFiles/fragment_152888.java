public int compareTo(Human o) {
    if(this.age==o.age && o instanceof Fysiker) {
        return this.year - ((Fysiker)o).year;
    }
    return super.compareTo(o);
}