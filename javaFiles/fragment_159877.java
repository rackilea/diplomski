public validParams(String paramA, String paramB, String paramC, Long id) {
    CompanyDto companyDto = loadCompanyDto(id);
    validA(paramA, companyDto);
    validB(paramB, companyDto);
    validC(paramC, companyDto);
}