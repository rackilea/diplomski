String [] sa = new String[5];
foo(sa);
String s = sa[0]; // If this line was reached, s would
                  // definitely refer to a String (though
                  // with the given definition of foo, this
                  // line won't be reached...)