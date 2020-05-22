PrintWriter out = null;
try {
    out = new PrintWriter(new FileWriter("movie.txt"));
    while(data != null) {
        m = (Movie)data;
        out.println(m.toString());
        data = listMovie.getNext();
    }
} 
finally {
    if (out != null) {
        out.close();
    }
}