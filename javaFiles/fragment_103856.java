// Assuming pid is public
public int hashCode() {
  return this.pid;
}

public equals(Object object) {
  return this.pid == ((Product)object).pid;
}