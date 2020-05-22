@Override
public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    Message message = (Message) o;

    return id == message.id;

}

@Override
public int hashCode() {
    return id;
}