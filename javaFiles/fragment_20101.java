public static class Course<E>{
    private E idOrName;
    private float avg;

    public Course(E idOrName, float avg){
        this.idOrName = idOrName;
        this.avg = avg;
    }
}