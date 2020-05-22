@Override
public boolean equals(Object e) {
    if ( e instanceof element &&
    this.firstPoint2D.equals(((element)e).firstPoint2D) && 
     this.secondPoint2D.equals(((element)e).secondPoint2D) && 
     this.lastBoolean == ((element)e).lastBoolean)
        return true;
    else
        return false;
}