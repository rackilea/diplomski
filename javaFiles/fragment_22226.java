AbstractTaxPolicyFactory absFactory = new ChinaTaxPolicyFactory();
// or use a static factory method: 
// TaxPolicyFactoryCreator.createNewFactory(Country.CHINA); 
ItemCategoryTaxPolicy itemCatTaxPolicy = absFactory.createItemCategoryTaxPolicy();
addTaxPolicy(itemCatTaxPolicy);
ImportDutyTaxPolicy importDutyTaxPolicy = absFactory.createImportDutyTaxPolicy();
addTaxPolicy(importDutyTaxPolicy);