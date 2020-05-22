@AllArgsConstructor
@Service
public class ServiceClass {

    private final ObjectProvider<ProtoTypeBean> provider;

    public void demoMethod(ArrayList<String> someArrayList) {
        PrototypeBean pb = provider.getIfUnique();
        for(var singleString: someArrayList) {
            pb.setFieldValue(singleString);
            pb.add(prototypeBean);              
        }
        System.out.println(prototypeBean.toString());
    }
}