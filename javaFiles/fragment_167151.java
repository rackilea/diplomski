@Override
public boolean equals(Object otherObject) {
    // Objects are equal if they have the same value, and next has the same value
    if (otherObject instanceof ListNode) {
        ListNode other = (ListNode)otherObject;
        return first.equals(other.first);
    }
    else {
        return false;
    }
}
@Override
public int hashCode() {
    return first.hashCode();
}