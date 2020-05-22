@Throws(ServletException::class, IOException::class)
override fun doPost(req: HttpServletRequest, resp: HttpServletResponse) {
    val gson = GsonFactory.getDefaultInstance()       
    val json = gson.createJsonGenerator(resp.writer)

    val text = GoogleCloudDialogflowV2IntentMessage()
    // platform has to be set
    text.platform = "ACTIONS_ON_GOOGLE"
    text.simpleResponses = GoogleCloudDialogflowV2IntentMessageSimpleResponses()
     //set both display text and text to speech
    val simpleText = GoogleCloudDialogflowV2IntentMessageSimpleResponse()
                       .setTextToSpeech("text to speech")
                       .setDisplayText("display text")
    text.simpleResponses.simpleResponses = mutableListOf(simpleText)


    val card = GoogleCloudDialogflowV2IntentMessage()
    card.platform = "ACTIONS_ON_GOOGLE"
    // you must have an image and/or formatted text set on the card
    card.basicCard = GoogleCloudDialogflowV2IntentMessageBasicCard().setTitle("Hello World").setFormattedText("The Text")


    val myResponse = GoogleCloudDialogflowV2WebhookResponse()
    // text is necessary and it must be first in the list
    myResponse.fulfillmentMessages = mutableListOf(text, card)

    json.serialize(myResponse)
    json.flush()
}