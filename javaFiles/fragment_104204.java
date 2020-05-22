source.setOnMouseDragged(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                System.out.println("MouseScreenX:" + event.getScreenX() + ", MouseScreenY:" + event.getScreenY());
                System.out.println("MouseSceneX:" + event.getSceneX() + ", MouseSceneY:" + event.getSceneY());

                // Execute some code here(maybe it has to run in a different
                // Thread)
                // ...code
                // ....
            }
        });