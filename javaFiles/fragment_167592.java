@Autowired
private MessageSource messageSource;

@RenderMapping(params = "render=details")
public String showDetails (Model model, Locale locale) {
    messageSource.getMessage(<your key goes here>, null, locale);
}