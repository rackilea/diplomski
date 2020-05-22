// (java code)
/**
 * Defines a validation rule.
 */
public interface IValidationRule
{
    /**
     * Returns a description of this
     * validation rule.
     */
    String getDescription();

    /**
     * Returns true if this rule
     * is matched.
     */
    boolean matches(String tpin);
}