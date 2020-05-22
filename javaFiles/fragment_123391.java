Node Statement():
{
    Node n, child;
}
{
    { n = new Node("Statement"); }
    (
       child = Input()       { n.addChild(child); }
    |
       child = Output()      { n.addChild(child); }
    | 
       etc etc
    |
       <NEWLINE>
    )
    { return n; }
}