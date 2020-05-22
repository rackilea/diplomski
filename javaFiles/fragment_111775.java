scala> new jfunc.Acceptor().f(s => println(s))
<console>:12: error: type mismatch;
 found   : Unit
 required: Void
       new jfunc.Acceptor().f(s => println(s))
                                          ^

scala> new jfunc.Acceptor().f { s => println(s) ; null }
hello, world.