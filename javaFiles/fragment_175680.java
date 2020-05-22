class Run {
    int first,last,length,value;
    public Run(int value, int first, int last){
        this.value = value;
        this.first = first;
        this.last = last;
        length = last - first + 1;
    }
    public int value(){return value;}
    public int first(){return first;}
    public int last(){return last;}
    public int length(){return length;}
}