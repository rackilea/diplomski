@Override
  public int hashCode() {
    int hash = 31;
    hash = 29 * hash + Objects.hashCode(name);
    hash = 29 * hash + Objects.hashCode(passwort);
    return hash;
  }