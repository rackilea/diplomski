@Override
public int compareTo(EfdisJournal other) {
    int i = this.type.compareTo(other.type);
    if (i != 0) {
        return i;
    }
    if ((this.bookingDate==null) ^ (other.bookingDate==null)) {
        return (this.bookingDate==null ? -1 : 1);
    }
    if (this.bookingDate != null && other.bookingDate != null) {
        i = this.bookingDate.compareTo(other.bookingDate);
    }
    if (i != 0) {
        return i;
    }
    if ((this.journalId==null) ^ (other.journalId==null)) {
        return (this.journalId==null ? -1 : 1);
    }
    if (this.journalId != null && other.journalId != null) {
        i = this.journalId.compareTo(other.journalId);
    }
    if (i != 0) {
        return i;
    }
    return this.account.compareTo(other.account);
}