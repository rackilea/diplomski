Iterator<TestResult> iterator = testResults.iterator();
while(iterator.hasNext()) {
    TestResult result = iterator.next();
    if (!result.getSeverity().equals(Severity.INFO)) {
        iterator.remove();
    }
}

//Now testResults contains all elements that do not have Severity of INFO