class SortbyScore implements Comparator<Ergebnisse> { 
    @Override
    public int compare(Ergebnisse a, Ergebnisse b) { 
    return b.getScore() - a.getScore(); 
    } 
}