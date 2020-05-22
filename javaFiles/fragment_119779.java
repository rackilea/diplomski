@Override
public String toString() {
   String s = "Movie #\t"+getMovieNumber()+ "\n";  // \n is a linebreak and \t is indention
   s += "Title: \t"+getName()+"\n";
   s += "Description: \t"+getDescription()+"\n";
   s += "Year: \t"+getYear();
   return s;
}