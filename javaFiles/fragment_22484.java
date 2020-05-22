ResultOfB resultB = null;
ResultOfC resultC = null;

@Override
void onReceive(Object message) {
    if(message instanceof ProcessData) {
        ProcessData pData = message as ProcessData

        resultB = null;
        resultC = null;

        Widget widget = pData.widget
        RunActorA runA = new RunActorA(widget)

        actorA.tell(runA, self)
    } else if (message instanceof ResultOfA) {
        ResultOfA resultA = message as ResultOfA

        actorB.tell(resultA)
        actorC.tell(resultA)
    } else if (message instanceof ResultOfB) {
        resultB = message as ResultOfB

        if (resultC != null) {
            actorD.tell(composedResultBAndC)
        }
    } else if (message instanceof ResultOfC) {
        resultC = message as ResultOfC

        if (resultB != null) {
            actorD.tell(composedResultBAndC)
        }
    } else if (message instanceof ResultOfD) {
        //Do stuff with the result
    }
}