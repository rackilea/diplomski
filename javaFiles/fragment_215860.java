val email = RxTextView.textChanges(emailEditText)
val emailIsValid = email.map { charSequence ->
  Log.d("asdf", "emailIsValid call: " + charSequence)
  Pattern.matches(Patterns.EMAIL_ADDRESS.pattern(), charSequence)
}.publish()
RxView.focusChanges(emailEditText)
    .withLatestFrom(emailIsValid) { hasFocus, emailIsValid ->
      (!hasFocus && !emailIsValid)
    }
    .subscribe { showError ->
      if (showError) {
        Log.d("asdf", "error")
      }
    }
val password = RxTextView.textChanges(passwordEditText)
Observable.combineLatest(emailIsValid, password) { emailIsValid, password ->
  Log.d("asdf", "valid: $emailIsValid, password: $password")
  (emailIsValid && password.length > 0)
}.subscribe(RxView.enabled(button))
emailIsValid.connect()