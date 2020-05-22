//click the button
 onView(withId(R.id.SubmitBtn)).perform(scrollTo(), click());
 //check to see if method was called then capture the interface
 verify(mockReq).InformationRequest(ArgumentMatchers.anyMap(),anyString(),captor.capture());
  //get the interface
 ServerInterface serverInter = captor.getValue();
 Object obj = "Already taken";
 //make use of the interface
 serverInter.OnSuccess(obj);