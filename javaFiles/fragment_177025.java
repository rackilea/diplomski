String name;
Node current = null;

while(true)
{ 
 System.out.println ("Enter a name:");
 name = stdin.readLine ();

if( name.equals("exit") ) break;

 if( current == null ) {
    current = new Node(name);
}
else {
   current.next = new Node(name);
   current = current.next;
}

}