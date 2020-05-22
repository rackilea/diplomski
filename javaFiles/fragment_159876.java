@Service
public class Validator implements IValidator {

    @Resource
    private CompanyRepository companyRepository;

    @Override
    public void validA(String paramA, Long id) {
        validA(paramA, loadCompanyDto(id));
    }

    private void validA(String paramA, CompanyDto companyDto) {

        //do some logic processing of the paramA

        //do some logic
    }

    private CompanyDto loadCompanyDto(Long id) {
        Company company = companyRepository.load(id);
        //convert company to companyDto
        return CompanyParser.fromCompany(company);
    }
}