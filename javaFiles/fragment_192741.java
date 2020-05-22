public Object Consultation()
{

    Object item = list.get(0); // fix

    list.remove(0);

    return item;
}