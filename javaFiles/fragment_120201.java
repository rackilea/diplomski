Activity reply = new Activity()
        .withType(ActivityTypes.MESSAGE)
        .withRecipient(activity.from())
        .withFrom(activity.recipient())
        .withAttachments(Arrays.asList(
                new Attachment()
                        .withContentType("application/vnd.microsoft.card.hero")
                        .withContent(new HeroCard()
                                .withTitle("Hero Card")
                                .withSubtitle("BotFramework")
                                .withButtons(Arrays.asList(new CardAction()
                                    .withValue("https://docs.microsoft.com/en-us/azure/bot-service/")
                                    .withTitle("Get started")
                                    .withType(ActionTypes.OPEN_URL)
                                ))
                                .withImages(Collections.singletonList(new CardImage()
                                        .withUrl("https://sec.ch9.ms/ch9/7ff5/e07cfef0-aa3b-40bb-9baa-7c9ef8ff7ff5/buildreactionbotframework_960.jpg"))))

        ));