@Override
public boolean equals(Object obj) {
    if (this == obj)
        return true;
    if (obj == null)
        return false;
    if (!getClass().isAssignableFrom(obj.getClass()))
        return false;
    AbstractEntity other = (AbstractEntity) obj;
    if (getId() == null) {
        if (other.getId() != null)
            return false;
    } else if (!getId().equals(other.getId()))
        return false;
    return true;