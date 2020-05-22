@MessageMapping("/call" )
@SendTo("/topic/showResult")
public RetObj process(ListId[] listIds) {
   if (!listIds.isEmpty()) {
        for(ListId listId: listIds) {

       }
}