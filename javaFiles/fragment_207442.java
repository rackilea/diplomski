class ThirdPartyReadOnlyClass {
   private String ignoredPropertyFromThirdParty;

   public String getIgnoredPropertyFromThirdParty() {
      return ignoredPropertyFromThirdParty;
   }
}

abstract class MixIn {
  @JsonIgnore
  String getIgnoredPropertyFromThirdParty();
}