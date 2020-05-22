@Override
public boolean equals(Object o) {
    if (this == o)
        return true;
    if (o instanceof Entity){
        Entity that = (Entity) o;
        return this.id == null ? that.id == null : this.id.equals(that.id);
    }
    return false;

}