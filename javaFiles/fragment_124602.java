put the below line in your jsp
<input type='hidden' value='${fn:length(interestParam)}' id="interestParamCount"/>

here is how to iterate in your js file

  for(counter = 0 ; counter < $('#interestParamCount').val();counter++){
      alert($('.minamount-'+counter).text());
      alert($('minamount-'+counter).text());
      alert($('intrate-'+counter).text());
  }