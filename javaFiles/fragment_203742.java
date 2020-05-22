class Wrapper implements ThirdParty1, MyInterface
{
  private ThirdParty1 original;
  Wrapper(ThirdParty1 original_) { original=original_; }
  // all implemented functions from ThirdParty call said method on original
}