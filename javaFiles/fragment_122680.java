for (ITestResult testResult : testResultSet) {
    String methodName = testResult.getName() + "(";
    for (Object arg : testResult.getParameters()) {
        methodName += arg == null ? "" : arg.toString() + ", ";
    }

    uniqueMethodMap.add(testResult.getName());
    methodList.add(testResult.getParameters().length > 0 ?    methodName.substring(0, methodName.length() - 2) + ")" : methodName + ")");
}