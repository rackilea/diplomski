public class MyTypeSafeEnumXmlAdapter extends XmlAdapter<Integer, MyTypeSafeEnum> {
    @Override
    public Integer marshal(MyTypeSafeEnum v) throws Exception {
        return v.getValue();
    }

    @Override
    public MyTypeSafeEnum unmarshal(Integer v) throws Exception {
        return MyTypeSafeEnum.fromInt(v);
    }
}