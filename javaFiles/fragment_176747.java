@Service
@Transational
public class PolicyManagement {
     @Transaction
     public void fooManagemantService() {
         policyIssuanceManagement.updatePolicy(currentPolicy);
         policyDetailManagement.insertDataInPolicyDetail(policyId, riskAmount, riskPercent, riskId, regionRisk, regionPercent, regionId, stepped, steppedPercent, steppedId, discount, discountPercent, discountId);
     }
}