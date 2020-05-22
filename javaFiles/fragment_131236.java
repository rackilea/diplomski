rule "302 case"
when 
    numberObject: NumberDetails(status==302)
then

    numberObject.setResult(numberObject.getA()+numberObject.getB());
end