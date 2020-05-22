public interface ForwardingCoreVerifiers
{
  CoreVerifiers coreVerifiers();

  default CoreVerifiers method1()
  {
    coreVerifiers().method1();
  }
}