public class MyFaceBotBehavior extends AbstractFaceBot {

  public void defineBehavior() {
     // Setting my tokens from Facebook (page token and validation token for webhook).
     FaceBotContext.getInstance().setup("myFacebookPageToken", "myFacebookWebhookValidationToken");

     // Defining a bot which will reply with "Hello World!" as soon as I write "Hi"
     addActionFrame(new MessageEvent("Hi"),
          new MessageAutoReply("Hello World!"));
 }
}