public class WineDAO {

    private static SqlSessionFactory ssf;

    static{ 
        try{
            Reader reader= org.apache.ibatis.io.Resources.getResourceAsReader("Config.xml");
            ssf=new SqlSessionFactoryBuilder().build(reader);
        }catch(Exception ex){ex.getMessage();}
    }

    public List<Wine> findAll() {

        List<List<Wine>>list = new ArrayList<List<Wine>>();

        list = ssf.openSession().selectList("findAll");

        for(int i=0; i<list.get(0).size(); i++)
        {
            System.out.println(list.get(0).get(i).getName());
        }

        return list.get(0);
    }
}