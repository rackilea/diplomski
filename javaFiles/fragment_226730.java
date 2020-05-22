@Override
public int compareTo(Movie m) {
    int c;
    if(this.title!=null && m!=null && m.getTitle()!=null){  
        c = this.title.compareTo(m.getTitle());
        if (c == 0)
            c = Integer.compare(this.year, m.getYear());            
    }
    return c;
}