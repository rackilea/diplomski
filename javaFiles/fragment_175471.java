dialogScene.addEventHandler(KeyEvent.KEY_RELEASED, event -> {
                    if (event.isAltDown() && event.getCode() == KeyCode.J )
                    {
                        dialog.hide();
                    }
                });