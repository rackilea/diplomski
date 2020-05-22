public Object getValueAt(int row, int column) {
    IFS ifs = listaMista.get(row);
    if(ifs instanceof SerieTv) { // first if block
        SerieTv serie=(SerieTv) ifs;
        switch (column) {
            // missing case 0 here
            case 1: return serie.getTitolo();
            ...
        }
    }
    if(ifs instanceof FilmTv) { // second if block
        FilmTv filmtv=(FilmTv) ifs;
        switch (column) { 
            // missing case 0 here too
            case 1: return filmtv.getTitolo();
            ...
        }
    }
    if(ifs instanceof Film) { // third if block
        Film film=(Film) ifs;
        switch (column) {
            // missing case 0 here too
            case 1: return film.getTitolo();
            ...
        }
    }
    return  null; // this is what you get on getValueAt(rowIndex, 0)
}