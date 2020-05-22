@Override
@SuppressWarnings("unchecked")
public List<Group> getGroups()
{
    return doWithSession(session -> (List<Group>)session.createQuery("from Group").list());
}