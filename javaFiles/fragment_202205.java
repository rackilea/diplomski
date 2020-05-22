public void wmiExecute() throws JIException {

    // Obtain Win32_Process and narrow it as IJIDispatch
    Object[] params = new Object[] {
        new JIString("Win32_Process"),
        JIVariant.OPTIONAL_PARAM(),
        JIVariant.OPTIONAL_PARAM()
    };

    // Obtain the default Win32_Process
    JIVariant[] service = this._wbemServices.callMethodA("Get", params);

    // Convert it to a IJIDispatch object
    IJIDispatch wbemObject = (IJIDispatch) JIObjectFactory.narrowObject(service[0].getObjectAsComObject());

    // Create input params
    Object[] paramsCalc = new Object[] {
             new JIString("calc.exe"),
             JIVariant.OPTIONAL_PARAM(),
             JIVariant.OPTIONAL_PARAM()
    };

    // Create the calculator process
    JIVariant[] results = wbemObject.callMethodA("Create", paramsCalc);
}