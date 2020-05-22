String message = null;
                if (notifyData.get(0).getappUpdate().equalsIgnoreCase("YES")) {
                    createNotificationForAppUpdate();
    //This will notify for App update
                } else if (notifyData.get(0).getcontentUpdate().equalsIgnoreCase("YES")) {
                    message = notifyData.get(0).getdetail();
        //This will notify for Content updte
                    generateNotification(context, message);
                } else {

//This will notify for special content
                    message = notifyData.get(0).getSpecialContent();
                    generateNotification(context, message);

                }