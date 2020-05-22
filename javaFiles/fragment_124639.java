private void sendDocUploadingAFile(Long chatId, java.io.File save,String caption) throws TelegramApiException {

    SendDocument sendDocumentRequest = new SendDocument();
    sendDocumentRequest.setChatId(chatId);
    sendDocumentRequest.setNewDocument(save);
    sendDocumentRequest.setCaption(caption);
    sendDocument(sendDocumentRequest);
}