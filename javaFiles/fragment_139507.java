if("200".equals(SampleResult.getResponseCode())&&
    "0".equals(SampleResult.time.toString())) 

       { // Success

SampleResult.setSuccessful(false); // Change sampler status to success
AssertionResult.setFailure(true); // Set assertion status to success as well
   } 
    else {
   AssertionResult.setFailure(false); // Set assertion status to failure
   }