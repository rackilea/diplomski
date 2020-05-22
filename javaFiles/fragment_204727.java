@Test
public void onLoadChatrooms() throws Exception {
    when(getChatroomsService.getChatrooms(anyString(), any(RequestBody.class)))
            .thenReturn(call);

    chatPresenter.onLoadChatrooms(accountId, "0");

    verify(call).enqueue(callback.capture());
    callback.getValue().onResponse(call, getResponse());

    verify(getChatroomsService).getChatrooms(apiToken,requestBody);
    verify(view).showData(chatroomsResponseNestedItems);
}