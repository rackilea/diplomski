@Override
public boolean equals(Object otherUser) {
    if(otherUser == null) return false;
    else if (!(otherUser instanceof UserDetails)) return false;
    else return (otherUser.hashCode() == hashCode());
}

@Override
public int hashCode() {
    return user.getEmail().hashCode() ;
}