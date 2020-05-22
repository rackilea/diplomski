@Component("yay")
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
public BooYay implements Boo
{...}


@Component("hoo")
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
public BooHoo implements Boo
{...}