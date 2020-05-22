TypeDescription commandBase = new TypePool.Default.ofClassPath()
    .locate("my.package.CommandBase");
new ByteBuddy()
  .redefine(commandBase, ClassFileLocator.ForClassLoader.ofClassPath())
  .method(returns(Block.class)).intercept(MethodDelegation.to(CppBlockInterceptor.class))
  .make()
  .load(ClassLoader.getSystemClassLoader(), ClassLoadingStrategy.Default.INJECTOR);

CppBlockInterceptor.getBlockByText(null, "1").getLocalizedName()