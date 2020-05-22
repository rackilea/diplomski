// Remove Contact
public boolean removeContact(String fullname) {
    for (int i = 0; i < count; i++) {
        // No need for an else here
        if (fullname.equals(contacts[i].getFullName())) {
            for (int j = i; j < count; j++) {
                contacts[j] = contacts[j + 1];
            }
            count--;
            return true;
        }
    }
    return false;
}