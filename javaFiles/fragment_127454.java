public class MyBean {

    private String paramInfo;

    public void setParamInfo(String p) {
        paramInfo = p;
    }

    public String getParamInfo() {
        return paramInfo;
    }

    public List<String> getStuff(String param) {
        param = paramInfo; // substitute the value here
        List <String> list1 = Arrays.asList("A", "B", "C");
        List<String> list2 = new ArrayList<>();
        list2.addAll(list1);
        list2.add(param); // use the param value here
        return list2;
    }
}