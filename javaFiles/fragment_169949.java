import a.b.c.Languages;
 import a.b.c.LanguagesTableDto;

 @Autowired
 @Qualifier("languagesDtoMapper")
 private DtoMapper<Languages, LanguagesTableDto> partnerLanguageDtoMapper;