@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true, jsr250Enabled = true)
public class MethodSecurityConfig extends GlobalMethodSecurityConfiguration {

    private DefaultMethodSecurityExpressionHandler defaultMethodExpressionHandler = new DefaultMethodSecurityExpressionHandler();

    @Override
    protected MethodSecurityExpressionHandler createExpressionHandler() {
        return defaultMethodExpressionHandler;
    }

    public class DefaultMethodSecurityExpressionHandler extends org.springframework.security.access.expression.method.DefaultMethodSecurityExpressionHandler {

        @Override
        public StandardEvaluationContext createEvaluationContextInternal(final Authentication auth, final MethodInvocation mi) {
            StandardEvaluationContext standardEvaluationContext = super.createEvaluationContextInternal(auth, mi);
            ((StandardTypeLocator) standardEvaluationContext.getTypeLocator()).registerImport(Permission.class.getPackage().getName());
            return standardEvaluationContext;
        }
    }

}


    @PreAuthorize("hasAuthority(T(Permission).APPEND_DECISION)")
    @RequestMapping(value = "/{decisionId}/decisions", method = RequestMethod.PUT)
    public DecisionResponse appendDecisionToParent(@PathVariable @NotNull @DecimalMin("0") Long decisionId, @Valid @RequestBody AppendDecisionRequest decisionRequest) {
    ...
        return new DecisionResponse(decision);
    }