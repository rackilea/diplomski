@Inject
private XyzAction xyz;

@Rule
public ResourceTestRule resources = ResourceTestRule
        .builder()
        .addResource(new AbcResource(() -> xyz))
        .build();