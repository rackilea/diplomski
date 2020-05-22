@Override
    public boolean equals(Object otherObject) {
        // Objects are equal if they have the same value, && next has the same value
        if (otherObject instanceof Node) {
            Node other = (Node)otherObject;
            return data.equals(other.data) && ((next == null && ((Node) otherObject).getNext() == null) || next.equals(((Node) otherObject).next));
        }
        else {
            return false;
        }
    }

    @Override
    public int hashCode() {
        return data.hashCode();
    }