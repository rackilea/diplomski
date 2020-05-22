while (true) {
    acceptConnectionOnNormalPort()
    connectToTargetPort()
    startThreadCopyingDataFromAcceptedPortToTargetPort()
    startThreadCopyingDataFromTargetPortToAcceptedPort()
}