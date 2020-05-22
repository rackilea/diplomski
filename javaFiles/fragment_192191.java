public class AttributeRule implements Template {

    @Override
    public String writeTemplate(BusinessRule businessRule) throws Exception {
        String link = TemplateReader.getInstance().getLinkToQuery(businessRule.getBusinessRuleTypeCode());
        String template = TemplateReader.getInstance().readQuery(link);
        ST templateFixer = new ST(template);
        templateFixer.add("code", businessRule.getBusinessRuleTypeCode());
        templateFixer.add("attribute_table", businessRule.getListOfTables().get(0).getName());
    }
}

public class AttributeCompareRule extends AttributeRule {

    @Override
    public String writeTemplate(BusinessRule businessRule) throws Exception {
        super.writeTemplate(rule);
        // Custom class code here
        templateFixer.add("operand", businessRule.getOperator().getName());
        templateFixer.add("compare_with", businessRule.getListOfValues().get(0).getValue());
        templateFixer.add("error", businessRule.getErrorMessage());
        String templateDLL = templateFixer.render();
        return templateDLL;
    }
}

public class AttributeRangeRule extends AttributeRule {
     super.writeTemplate(rule);
    // Custom class code here
}