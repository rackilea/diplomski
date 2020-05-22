// (java code)
public class Validator
{
    // instantiate all known rules
    IValidationRule[] rules = new IValidationRule[] {
        new RepetitiveDigitsRule(),
        new StartsWithZeroRule()
    };

    // validate tpin using all known rules
    public boolean validate(String tpin)
    {
        System.out.print("Validating TPIN " + tpin + "... ");

        // for all known rules
        for (int i = 0; i < rules.length; i++)
        {
            IValidationRule rule = rules[i];

            // if rule is matched?
            if (rule.matches(tpin))
            {
                // print rule description
                System.out.println("Error: " + rule.getDescription());
                return false;
            }
        }
        System.out.println("Success.");
        return true;
    }
}