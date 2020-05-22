public class MovieCompartor implements Comparator<Movie>{
    public int compare(Movie m1, Movie m2) {
        int c;
        if(m!=null && m2!=null){
            if(m1.getTitle()!=null && m2.getTitle()!=null)
                c = m1.getTitle().compareTo(m2.getTitle());
            if (c == 0)
                c = Integer.compare(m1.getYear(), m2.getYear());            
        }
        return c;
    }
}