class Part {
  public int hashCode() {
    //don't include getCompound().hashCode()
    return getSomeUniqueName() == null ? 0 : getSomeUniqueName().hashCode();
  }

  public boolean equals(Object o)
  {
    if (this == o) return true;
    if (!o instanceof Part) return false;

    Part part = (Part) o;

    if (getCompound() != null ? !getCompound().equals(part.getCompound()) : part.getCompound()!= null) 
       return false;
    if (getSomeUniqueName()!= null ? !getSomeUniqueName().equals(part.getSomeUniqueName()) : part.getSomeUniqueName()!= null)
        return false;

    return true;
  }
}