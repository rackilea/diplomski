Message m = queueReceiver.receive();
 if (m instanceof DataRequest) {
     DataRequest message = (DataRequest) request;
     queueSender.send(service.getData(request.getDataId())); //service call
 } else {
     // Handle error
 }