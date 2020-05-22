//Don't do this!
class Z { 
    static { i = j + 2; } //Produces a compilation error
    static int i, j;
    static { j = 4; }
}