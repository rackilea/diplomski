@ManyToMany
@JoinTable(
  name="ProductModelI18n",
  joinColumns={@JoinColumn(name="productModel", referencedColumnName="idproductModel")},
  inverseJoinColumns={@JoinColumn(name="languageCountry", referencedColumnName="idLanguage")})
private List<LanguageCountry> languageCountries;