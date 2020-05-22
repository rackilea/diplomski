@AssertTrue(message="{invalidCode}")
private boolean isValidActivationCode() { ... }


@AssertTrue(message="{alreadyActivated}")
private boolean isAlreadyActivated() {

     if(isValidActivationCode()) {
           <Logic for isAlreadyActivated>
      )

}