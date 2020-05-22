public class ParentA {
    @Valid
    @ConvertGroup(from=Default.class, to=ParentA.class)
    private Child c;
}

public class ParentB {
    @Valid
    @ConvertGroup(from=Default.class, to=ParentB.class)
    private Child c;
}

public class Child {
    @NotNull(groups=ParentA.class)
    @Null(groups=ParentB.class)
    private String name;
}