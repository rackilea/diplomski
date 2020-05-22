public List<ThingDTO> getThingDTOs( ... )
{
    Query query = em().createQuery("FROM Thing t WHERE ...");
    query.setParameter( ... );

    List<Thing> things = query.getResultList();

    List<ThingDTO> thingDTOs = new ArrayList(things.size());
    for(Thing t : things)
    {
        thingDTOs.add(new ThingDTO(t));
    }

    return thingDTOs
}