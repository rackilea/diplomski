ResponseList<Status> list = twitter.getHomeTimeline();
    for (Status each : list) {

        System.out.println("Sent by: @" + each.getUser().getScreenName() + " - " + each.getUser().getName() + "\n"
                + each.getText() + "\n");
    }