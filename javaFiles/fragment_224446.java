navigator = new Navigator(UI.getCurrent(),this);
navigator.addView(LoInf.NAME, LoInf.class);
        navigator.addView(RMQcl.NAME,RMQcl.class);

button = new Button("Login", new Button.ClickListener(){
            @Override
            public void buttonClick(ClickEvent event){
            layout.addComponent(new Label("establishing connection ..."));
                navigator.navigateTo(RMQcl.NAME);

            }

        });