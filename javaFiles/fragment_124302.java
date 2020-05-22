public class ScreenContext implements Context
{

   private final BeanManager m_beanManager;

   public ScreenContext(final BeanManager p_BeanManager)
   {
      m_beanManager = p_BeanManager;
   }

   public void myMethod()
   {
      NavigationHandler NavigationHandlerBean = getNavigationHandler();
      ...
      ...
   }

   private NavigationHandler getNavigationHandler()
   {
      final Set<Bean<?>> beans = m_beanManager.getBeans(NavigationHandler.class);
      final Bean<?> bean = m_beanManager.resolve(beans);

      return (NavigationHandler) m_beanManager.getReference(bean, NavigationHandler.class, m_beanManager.createCreationalContext(bean));
   }