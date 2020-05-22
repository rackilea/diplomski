rule "Fixed / Floating ccy rule"
when
    $n1: NodeElement( id == "FixedCurrency")
    $n2: NodeElement( id == "FloatingCurrency", value != $n1.value)
then
    errors.addError( "Currency", "Fixed currency should be same as Floating currency" );
end

rule "Payment / Settlement date rule"
when
    $n1: NodeElement( id == "tradeDate")
    $n2: NodeElement( id == "paymentDate", value != $n1.value)
    eval(!(DateValidation.paymentDateValidation($n1.value, $n2.value)))
then
    errors.addError($n2.value.toString(), "Payment date should be after trade date" );
end