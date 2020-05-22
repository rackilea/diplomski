@Component("accessChecker")
public class AccessChecker {
  public boolean hasAccessToCompany(Long companyId) {
    return checkAccessRightsHere(SecurityContextHolder.getContext().getAuthentication(), companyId);
  }
}  

@Controller
public class CompanyController {
   @RequestMapping("/company/{companyId}")
   @PreAuthorize("@accessChecker.hasAccessToCompany(#companyId)")
   public CompanyDto getCompany(@PathVariable("comapanyId") Long companyId) {

   }
}