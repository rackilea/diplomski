col2_Nickname.setCellFactory(lambda -> new TableCell<ChatMessage, Boolean>() {
            @Override
            public void updateItem(Boolean sentOrReceived, boolean empty) {
                super.updateItem(sentOrReceived, empty);
                if (empty) {
                    setText(null);
                }else{
                    setText(sentOrReceived ? "MyNickname" : "His/Her nickname");
                }
            }
        });