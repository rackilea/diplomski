public final class Verifiers
  implements ForwardingCoreVerifiers, ForwardingGuavaVerifiers
{
  public CoreVerifiers coreVerifiers()
  {
    return new CoreVerifiersImpl(...);
  }
  public CoreVerifiers guavaVerifiers()
  {
    return new GuavaVerifiersImpl(...);
  }
}