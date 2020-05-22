@Override
public boolean equals(Object o){
    if (o == null || !(o instanceof CoAutoria)) return false;
    if (o == this) return true;
    return this.compareTo((CoAutoria)o) == 0;
}

@Override
public int compareTo(CoAutoria o) {
    List<String> authors1 = Arrays.asList(autor1.getNome(), autor2.getNome());
    List<String> authors2 = Arrays.asList(o.autor1.getNome(), o.autor2.getNome());
    Collections.sort(authors1);
    Collections.sort(authors2);
    for (int i=0;i<authors1.size();i++){
        int compare = authors1.get(i).compareTo(authors2.get(i));
        if (compare != 0)
            return compare;
    }
    return 0;
}