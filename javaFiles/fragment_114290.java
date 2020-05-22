@Service("SampleBeanParent")
@Validated(Group1.class)
public class SampleBeanParent {

    public void acceptChildBean(
            @Valid SampleBean childBean) throws NoSuchMethodException, SecurityException {
        System.out.println("successfully finished");
    }

}

@Service("SampleBean")
public class SampleBean {

    @NotNull(message = "value can not be null", groups = Group1.class)
    private Integer value;

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

}