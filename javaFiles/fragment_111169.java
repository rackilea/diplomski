@JmsListener(id = "q1", destination = "queue1")
    public void processOrder(String message) {. . .}
@JmsListener(id = "q2", destination = "queue2")
    public void processOrder(String message) {. . .}
:
:
@JmsListener(id = "qN", destination = "queueN")
    public void processOrder(String message) {. . .}