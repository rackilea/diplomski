class BetterAPI extends API {
  private BetterAPI(APIOption option, AnotherAPIOption anotherOption) {
    this.APIOption = option;
    this.AnotherAPIOption = anotherOption;
  }

  public static BetterAPI createWithOptionSetA() {
    return new BetterAPI(Option1, Option2);
  }

  public static BetterAPI createWithOptionSetB() {
    return new BetterAPI(Option3, Option4);
  }

  // ...
}