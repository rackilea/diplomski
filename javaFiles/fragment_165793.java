....
public Example ()
{
    this.s = null;
}

public Example (String s)
{
    this.s = s;
}
....
public void setS (String s)
{
    this.s = s;
}
....
Example ex = new Example ("something");
Example ex2 = new Example ();
ex2.setS("Something Else");