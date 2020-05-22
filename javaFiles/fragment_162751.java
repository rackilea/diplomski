Button logInBtn = new Button("Log in");
logInBtn.setOnAction(e -> theStage.getScene().setRoot(logInRoot));
Button signUpBtn = new Button("Sign in");
logInBtn.setOnAction(e -> theStage.getScene().setRoot(signUpRoot));
Button unloggedBtn = new Button("Continue unlogged");
logInBtn.setOnAction(e -> theStage.getScene().setRoot(gmodeRoot));