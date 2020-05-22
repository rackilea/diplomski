public List<Creature> SelectCreature(String Name)
{
    // List is an interface, you must use a specific implementation
    // like ArrayList:
    List<Creature> foundCreature = new ArrayList<Creature>();

    //For the customer name that equals what has been searched...
    for ( Creature c: m_creature)
    {
        //
        if (c.CreatureName.equalsIgnoreCase(Name))
            foundCreature.add(c);
    }

    return foundCreature;
}