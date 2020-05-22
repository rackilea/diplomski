class EngineComparator implements Comparator<Engine> {
    @Override
    public int compare(Engine o1, Engine o2) {
        int result = o1.getProdType().compareTo(o2.getProdType());
        return (result == 0) ? o1.getPercent().compareTo(o2.getPercent()) : result;
    }
}