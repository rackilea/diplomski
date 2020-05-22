public class Word {

   private Map<String, DocumentSaveHandler> handlers; // note its the interface, not an implementation - map of supported types to the actual handler


   public onSaveButtonPressed(String selectedDocType) {
      Document doc = getDocumentToSave();
      DocumentSaveHandler handler  =  handlers.get(selectedDocType);
      handler.save(doc);
   } 
}