public class App 
{
    public static void main( String[] args ) throws RiakException
    {
        List<Person> personList = new ArrayList<Person>();

        Person p = new Person("Bob","111 Elm Street","555-1212");
        personList.add(p);
        p = new Person("Jenny","122 Spruce Lane","867-5309");
        personList.add(p);
        p = new Person("Steve","333 Oak place","555-1111");
        personList.add(p);


        IRiakClient client = RiakFactory.pbcClient();
        Bucket b = client.fetchBucket("people").execute();
        KryoPersonConverter converter = new KryoPersonConverter("people");

        for (Person p2 : personList)
        {
            b.store(p2).withConverter(converter).execute();
        }

        p = new Person();
        p.setName("Jenny");
        p = b.fetch(p).withConverter(converter).execute();
        assert(p.getPhone().equals("867-5309")); // I got your number