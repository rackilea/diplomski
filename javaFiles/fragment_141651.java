private Map<String, Object> context = new HashMap<>();

 ConversationService service = new ConversationService(ConversationService.VERSION_DATE_2016_09_20);
 service.setUsernameAndPassword('Your Watson service UserName', 'Your watson service PassWord');
 MessageRequest newMessage = new MessageRequest.Builder().inputText(inputmessage).context(context).build();
 MessageResponse response = service.message('Your Workspace Id', newMessage).execute();

   //Passing Context of last conversation
    if(response.getContext() !=null)
      {
        context.clear();

        context = response.getContext();

     }