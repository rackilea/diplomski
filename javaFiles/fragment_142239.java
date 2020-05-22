public MyClass() {
    // do stuff you know doesn't use injected fields
}
@PostConstruct
public void init() {
    BaseUtilBean bean = utilBeansMap.get("theKey");
    // do something with bean
}