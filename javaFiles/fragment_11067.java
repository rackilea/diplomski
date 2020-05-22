if (isCanceled) {
                    cancel();
                    isCanceled = false;
                } else {
                    int minutes = (int) (millisUntilFinished / 1000) / 60;
                    int seconds = (int) (millisUntilFinished / 1000) % 60;
                    mBuilder.setContentText(
                        "Time left: " + String.format(Locale.getDefault(), "%02d:%02d", minutes, seconds));
                    notificationManager.notify(3, mBuilder.build());
                }