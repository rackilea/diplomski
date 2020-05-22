@Override
public int hashCode() {
    System.out.println("In child hashCode: " + i);
    System.out.println("Parents hashCode: " + super.hashCode());
    return i;
}