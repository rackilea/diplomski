/**----------START------setting up conditional style and adding it in jasper design---------------*/
String expressionText = "$F{firstName}.trim().equals("-")";
JRDesignExpression cellExpression = new JRDesignExpression();
cellExpression.setText(expressionText);

JRDesignConditionalStyle conditionalCellStyle = new JRDesignConditionalStyle();
JRDesignStyle baseStyle = new JRDesignStyle();


conditionalCellStyle.setParentStyle(baseStyle);
conditionalCellStyle.setConditionExpression(cellExpression);
conditionalCellStyle.setHorizontalAlignment(HorizontalAlignEnum.CENTER);

baseStyle.setName("CONDITIONAL_STYLE");
baseStyle.setHorizontalAlignment(HorizontalAlignEnum.LEFT);
baseStyle.setBold(Boolean.FALSE);
baseStyle.setItalic(Boolean.FALSE);
baseStyle.setStrikeThrough(Boolean.FALSE);
baseStyle.setUnderline(Boolean.FALSE);
baseStyle.addConditionalStyle(conditionalCellStyle);

getJasperDesign().addStyle(baseStyle); //(here getJasperDesign() is a object of JasperDesign)
/**---------END-------setting up conditional style and adding it in jasper design---------------*/


/**----------START------setting up my text field---------------*/
JRDesignTextField cellTextField = new JRDesignTextField();
/**---------------------setting all other properties of textField--------------------*/
cellTextField.setStyle(getJasperDesign().getStylesMap().get("CONDITIONAL_STYLE")); //(here getJasperDesign() is a object of JasperDesign)
/**----------END------setting up my text field---------------*/