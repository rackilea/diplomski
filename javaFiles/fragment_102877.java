// TODO set up AbsApiState, AppInfo and ApiCallback objects
TelegramApi api = new TelegramApi(state, appInfo, apiCallback);

// Create request
String phoneNumber = "1234567890";
TLRequestAuthCheckPhone checkPhone = new TLRequestAuthCheckPhone(phoneNumber);

// Call service synchronously
TLCheckedPhone checkedPhone = api.doRpcCall(checkPhone);
boolean invited = checkedPhone.getPhoneInvited();
boolean registered = checkedPhone.getPhoneRegistered();
// TODO process response further