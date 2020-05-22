@WebService(endpointInterface = "com.enterprise.ws.WebServiceInterface")
public class WebServiceImpl implements WebServiceInterface{

    @Override
    public PojoSample listSample() {
        List<String> arrayList = new ArrayList<String>();
        arrayList.add("1212");

        PojoSample pojo = new PojoSample();
        pojo.setListSample(arrayList);
        return pojo;
    }
}