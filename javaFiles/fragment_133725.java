class IEnumWbemClassObject extends Unknown {

    public IEnumWbemClassObject(Pointer pvInstance) {
        super(pvInstance);
    }

    public HRESULT Next(int lTimeOut, int uCount, PointerByReference ppObjects, IntByReference puReturned) {
        // Next is 5th method of IEnumWbemClassObjectVtbl in
        // WbemCli.h
        return (HRESULT) _invokeNativeObject(4,
                new Object[] { getPointer(), lTimeOut, uCount, ppObjects, puReturned }, HRESULT.class);
    }
}