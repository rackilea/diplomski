Button logInBtn = new Button("Log in");
logInBtn.setOnAction(e -> theStage.getScene().setRoot(logInRoot));
Button signUpBtn = new Button("Sign in");
signUpBtn.setOnAction(e -> theStage.getScene().setRoot(signUpRoot));
Button unloggedBtn = new Button("Continue unlogged");
unloggedBtn.setOnAction(e -> theStage.getScene().setRoot(gmodeRoot));