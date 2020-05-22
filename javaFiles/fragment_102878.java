// Call service aynchronously
api.doRpcCall(checkPhone, new RpcCallbackEx<TLCheckedPhone>() {
    public void onConfirmed() { }
    public void onResult(TLCheckedPhone result) {
        boolean invited = checkedPhone.getPhoneInvited();
        boolean registered = checkedPhone.getPhoneRegistered();
        // TODO process response further
    }
    public void onError(int errorCode, String message) { }
});