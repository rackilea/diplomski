public class LoggingFailedCallsMBeanExporter extends MBeanExporter {

    protected ModelMBean createModelMBean() throws MBeanException {
        // super method does:
        // return (this.exposeManagedResourceClassLoader ? new SpringModelMBean() : new RequiredModelMBean());
        ModelMBean superModelMBean = super.createModelMBean();

        // but this.exposeManagedResourceClassLoader is not visible, so we switch on the type of the returned ModelMBean
        if (superModelMBean instanceof SpringModelMBean) {
              return new SpringModelMBean() {
                    @Override
                    public Object invoke(String opName, Object[] opArgs, String[] sig) throws MBeanException, ReflectionException {
                          try {
                                return super.invoke(opName, opArgs, sig);
                          } catch (MBeanException e) {
                                LOGGER.warn("Issue on a remote call", e);
                                throw e;
                          } catch (ReflectionException e) {
                                LOGGER.warn("Issue on a remote call", e);
                                throw e;
                          } catch (RuntimeException e) {
                                LOGGER.warn("Issue on a remote call", e);
                                throw e;
                          } catch (Error e) {
                                LOGGER.warn("Issue on a remote call", e);
                                throw e;
                          }
                    }
              };
        } else {
            return new RequiredModelMBean() {
                @Override
                public Object invoke(String opName, Object[] opArgs, String[] sig) throws MBeanException, ReflectionException {
                      try {
                            return super.invoke(opName, opArgs, sig);
                      } catch (MBeanException e) {
                            LOGGER.warn("Issue on a remote call", e);
                            throw e;
                      } catch (ReflectionException e) {
                            LOGGER.warn("Issue on a remote call", e);
                            throw e;
                      } catch (RuntimeException e) {
                            LOGGER.warn("Issue on a remote call", e);
                            throw e;
                      } catch (Error e) {
                            LOGGER.warn("Issue on a remote call", e);
                            throw e;
                      }
                }
          };
        }
}