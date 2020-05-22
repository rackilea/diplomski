rule "Reject a request"
when
    $req: PaymentValidationRequest()
then
    $req.setValid(false);
    update($req);
end

PaymentValidationRequest request = new PaymentValidationRequest(payment);
request.setPayment(payment);
List<Object> facts = new ArrayList<Object>();
facts.add(request);     
ksession.execute(facts);
...
boolean isValid = request.isValid()
List<ValidationAnnotation> annotations = request.getAnnotations();