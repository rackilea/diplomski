serverThread:
    while true:
        serverLock.acquire()

        if numberOfRequests < MAX_REQUESTS:
            packet = socket.receive()
            numberOfRequests++
            requestThread(packet).run()
        else
            serverMonitor.wait(serverLock);

        serverLock.release()

requestThread:
    //handle packet

    serverLock.acquire()

    if numberOfRequests == MAX_REQUESTS:

    numberOfRequests--
        serverMonitor.pulse();

    serverLock.release()