@Override
public boolean equals(Object obj) {
    if (this == obj)
        return true;
    if (!super.equals(obj))
        return false;
    if (getClass() != obj.getClass())
        return false;
    NewCar other = (NewCar) obj;
    if (color == null) {
        if (other.color != null)
            return false;
    } else if (!color.equals(other.color))
        return false;
    return true;
}