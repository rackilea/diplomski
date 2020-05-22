HtmlForm form = (HtmlForm) event.getComponent();
InputNumber inputNumber = new InputNumber();

inputNumber.setId("input1");
ValueExpression inputNumberValue = ef.createValueExpression(
context.getELContext(), "#{ruleManagedBean.inputNumber}",
Double.class);
inputNumber.setValueExpression("value", inputNumberValue);

form.getChildren().add(inputNumber);