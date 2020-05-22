@Override
  public boolean equals(Object obj) {

    if (obj == this) return true;       

    if (obj == null || !(obj.getClass().equals(this.getClass())))
        return false;

    FluxID otherFluxId = (FluxID)obj;

    if (this.getSource() == null
            || otherFluxId.getSource() == null
            || this.getBand() == null
            || otherFluxId.getBand() == null)
        return false;

    return this.getSource().equals(otherFluxId.getSource()) && 
           this.getBand().equals(otherFluxId.getBand());
}

@Override
public int hashCode() {

    if (this.getSource() == null && this.getBand() == null) return super.hashCode();

    return (this.getSource() != null ? this.getSource().hashCode() : 0 ) ^
           (this.getBand() != null ? this.getBand().hashCode() : 0 );

}