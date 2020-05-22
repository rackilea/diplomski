ObservableList<EmailData> emailData = FXCollections.observableArrayList(ed ->
        new Observable[]{
                ed.nameProperty(),
                ed.loginProperty(),
                ed.passwordProperty(),
                ed.commentsProperty()
        });