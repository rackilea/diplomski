private final Map<Integer, MyBean> map=new HashMap<Integer, MyBean>();

private void createAndStoreObject(JsonObject json, int i)
    throws ParseException
{
    SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    MyBean myBean=new MyBean(json.getInt("Id_temp"), json.getInt("temperatura"), format.parse(json.getString("Insertado_temp")));
    this.map.put(myBean.getId(), myBean);
}

class MyBean
{
    private final int id;

    private final int temperature;

    private final Date insertionDate;

    public MyBean(int id, int temperature, Date insertionDate)
    {
        super();
        this.id=id;
        this.temperature=temperature;
        this.insertionDate=insertionDate;
    }

    public int getId()
    {
        return this.id;
    }

    // ... getters ...
}