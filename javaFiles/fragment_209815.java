TextField DBName;
    TextField DBUserName;
    TextField DBPassword;

    DBName = new TextField("Enter DB Name");
    DBName.setColumns(20);
    DBUserName = new TextField("Enter UserName");
    DBUserName.setColumns(20);
    DBPassword = new TextField("Enter Password");
    DBPassword.setColumns(20);

    Button b = new Button("Connect");
    b.setImmediate(true);
    b.addListener(new ClickListener() {

        @Override
        public void buttonClick(ClickEvent event) {
            // post form values using java url connection


        }
    })