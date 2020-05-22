@ManyToOne
@PrimaryKeyJoinColumn(name="productModel", referencedColumnName="idproductModel")
private ProductModel productModels ;
@ManyToOne
@PrimaryKeyJoinColumn(name="languageCountry", referencedColumnName="idLanguage")
private LanguageCountry LanguageCountries;