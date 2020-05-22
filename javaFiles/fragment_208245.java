// Send method
BlockingQueue<Reply> q = new ArrayBlockingQueue<Reply>(1);
serialCom.registerQueue(myRequest.getId());
serialCom.sendRequest(myRequest);
return q.take();

//Listener
BlockingQueue<Reply> q = queueMap.get(incomingMessage.getId());
q.add(incomingMessage.getReply());