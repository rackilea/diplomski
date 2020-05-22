test {
    useTestNG() {
        configFailurePolicy 'continue'
        includeGroups 'myTestGroup'
        ...
    }
}