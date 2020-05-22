public void addCache(String user_id,int one,int two,int three,int four,int five)
{
    // You may want to check if an entry already exists for a user,
    // depends on logic in your application. Otherwise, this will
    // replace any previous entry for 'user_id'.
    cache.put(user_id, new ActiveSessionsObj(one, two, three, four, five));
}