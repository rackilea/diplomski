@PostConstruct
public void init() {
    System.out.println("initializing");
    this.languages = ConstantCodes.LANGUAGE_CODES;
    nativLang1 = "-1";
    nativLang2 = "-1";
}