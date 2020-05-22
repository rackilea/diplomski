@Stateless
public class MrBean  implements BeanInterface {}

@Stateless
public class MrsBean implements BeanInterface {}

@Inject
@Exact(MrBean.class)
private BeanInterface mrBean;