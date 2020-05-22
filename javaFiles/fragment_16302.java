@Override
public boolean equals(final Object obj)
{
    if (obj == null || obj.getClass() != getClass()) {
        return false;
    }
    if (obj == this) {
        return true;
    }

    PuntoImpl<T> other = (PuntoImpl<T>) obj;

    return other.puntoX.equals(this.puntoX) &&
           other.puntoY.equals(this.puntoY);
}