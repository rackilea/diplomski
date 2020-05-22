// Using ListIterator
public final void ricolora(Color c) {
    for (ListIterator<Pixel> it = this.pixel.listIterator(); it.hasNext(); ) {
        Pixel pi = it.next();
        Pixel gi = new Pixel(pi.getX(), pi.getY(), c);
        it.set(gi);
    }
}

// Using index
public final void ricolora(Color c) {
    for (int i = 0; i < this.pixel.size(); i++) {
        Pixel pi = this.pixel.get(i);
        Pixel gin = new Pixel(pi.getX(), pi.getY(), c);
        this.pixel.set(i, gin);
    }
}