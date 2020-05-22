public Kavi ()
{
    this.e = null;
}

public Kavi (Employee e)
{
    this.e = e;
}

public static void main(String[] args) {

    Employee e = new Kavi ();
    Kavi kt=new Kavi(e);
    ...
}