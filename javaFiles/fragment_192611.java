final ConnectableObservable<Notification> errorNotifications = 
                                                  pm.getNotificationObservable()
                                                    .filter(notification -> notification.getType().isError() && !notification.getLongMessage().isEmpty())
                                                    .replay(1);

errorNotifications.connect();

SwingObservable.fromMouseEvents(dialog.getMessagePanel().getMessageLabel())
           .map(MouseEvent::getClickCount)
           .filter(number -> number >= 2)
           .flatMap(integer -> errorNotifications.take(1))
           .subscribe(notification -> ErrorDialog.showError(dialog.getFrame(), "Error", notification.getLongMessage())));