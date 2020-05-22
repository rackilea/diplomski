public CrifServiceFaultException(String message)
{
    super(message);

    processCode = "";
    processDescription = "";
    transformCode= "";
    transformDescription= "";
    errorCode= "";
    errorDescription= "";
}

public CrifServiceFaultException(String processCode,
        String processDescription, String transformCode,
        String transformDescription)
{

    super(processDescription + " " + transformDescription);
    this.processCode = processCode;
    this.processDescription = processDescription;
    this.transformCode = transformCode;
    this.transformDescription = transformDescription;

    errorCode= "";
    errorDescription= "";
}

public CrifServiceFaultException(String errorCode, String errorDescription)
{
    super(errorDescription);
    setErrorCode(errorCode);
    setErrorDescription(errorDescription);

    processCode = "";
    processDescription = "";
    transformCode= "";
    transformDescription= "";
}