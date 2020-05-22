class Emp implements Comparable<Emp>
{
    String n;
    int i;
    public Emp(String n,int i)
    {
        this.n=n;
        this.i=i;
    }
    public void display()
    {
        System.out.println("there are string  "+n+"  int"+i);
    }

    public boolean equals(Object o){
        if(o instanceof Emp){
            Emp d = (Emp)o;
            return ((d.n.equals(n)) && (d.i==i));
        }
        return false;
    }

    public int hashCode(){
        return i/2 + 17;
    }


    public int compareTo(Emp d){
        if(this.i>d.i)
            return 1;
        else if(this.i<d.i)
            return -1;
        return this.n.compareTo(d.n);
    }

}