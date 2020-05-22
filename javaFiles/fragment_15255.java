String executionStatus;
String[] anArray = arguments.split("=");
for (int i; i < anArray.length; i++)
    if (anArray[i].contains("ExecutionStatus")){
        executionStatus = anArray[++i].replace("additionalCurrency","");
        executionStatus = executionStatus.trim();
    }
}