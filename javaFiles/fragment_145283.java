private class ContactsVO implements Comparable<ContactsVO>{

int number;

@Override
public int compareTo(ContactsVO that)
{
    if (this.number> that.number)
        return 1;
    else if (this.number< that.number)
        return -1;
    else
        return 0;

}

}