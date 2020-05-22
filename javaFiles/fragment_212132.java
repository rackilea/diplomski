// CSS Selector
selenium.click("css=li.nsg-form--drop-down--option[rel$=':9']"); // rel ends with :9
selenium.click("css=li.nsg-form--drop-down--option[rel^='3161898']"); // rel starts with 3161898

// XPath
selenium.click("xpath=//li[contains(@class, 'nsg-form--drop-down--option') and contains(@rel, ':9')]");
selenium.click("xpath=//li[contains(@class, 'nsg-form--drop-down--option') and starts-with(@rel, '3161898')]");