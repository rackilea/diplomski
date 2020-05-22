someNode.addEventHandler(MouseEvent.MOUSE_CLICKED, 
                        new EventHandler<MouseEvent>() {
                           @Override
                           public void handle(MouseEvent event) {
                              System.out.println(event.hashCode());
                           }
                        });