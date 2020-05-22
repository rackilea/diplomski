class Sample  {
    final int area;
    final Set<Integer> someData;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Sample sample = (Sample) o;

        if (area != sample.area) return false;
        if (!someData.equals(sample.someData)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = area;
        result = 31 * result + someData.hashCode();
        return result;
    }
}