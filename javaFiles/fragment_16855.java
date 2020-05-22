@Hint(displayName = "#DN_MainCallHint", description = "#DESC_MainCallHint",
        category = "general")
        @Messages({
    "DN_MainCallHint=MainCall",
    "DESC_MainCallHint=Warns the user when they are manually calling public "
            + "static void main"
})
public class MainCallHint {
    @TriggerPattern(value = "$str.equals(\"\")", //Specify a pattern as needed
            constraints = @ConstraintVariableType(variable = "$str", type
                    = "java.lang.String"))
    @Messages("ERR_MainCallHint=Directly calling main! Did you mean to do that?")
    public static ErrorDescription computeWarning(HintContext ctx) {
        return ErrorDescriptionFactory.forName(ctx, ctx.getPath(), Bundle.
                ERR_MainCallHint());
    }
}