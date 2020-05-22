private static synchronized String[] getTextFieldClassNames()
{
    if (textFieldClassNames == null)
    {
        textFieldClassNames = new String[]
        {
            java.lang.Boolean.class.getName(),
            java.lang.Byte.class.getName(),
            java.util.Date.class.getName(),
            java.sql.Timestamp.class.getName(),
            java.sql.Time.class.getName(),
            java.lang.Double.class.getName(),
            java.lang.Float.class.getName(),
            java.lang.Integer.class.getName(),
            java.lang.Long.class.getName(),
            java.lang.Short.class.getName(),
            java.math.BigDecimal.class.getName(),
            java.lang.Number.class.getName(),
            java.lang.String.class.getName()
        };

        Arrays.sort(textFieldClassNames);
    }

    return textFieldClassNames;
}

private void verifyTextField(JRTextField textField)
{
    verifyReportElement(textField);
    verifyFont(textField);
    verifyAnchor(textField);
    verifyHyperlink(textField);

    if (textField != null)
    {
        JRExpression expression = textField.getExpression();

        if (expression != null)
        {
            try
            {
                String className = expression.getValueClassName();
                if (className == null)
                {
                    addBrokenRule("Class not set for text field expression.", expression);
                }
                else if (Arrays.binarySearch(getTextFieldClassNames(), className) < 0)
                {
                    addBrokenRule("Class \"" + className + "\" not supported for text field expression.", expression);
                }
            }
            catch (JRRuntimeException e)
            {
                addBrokenRule(e, expression);
            }
        }
    }
}