class Listener implements Runnable {

   List<Sensor> sensorList;
   Listener(List<Sensor> list ){
      sensorList = list;
   }

   public void run(){
      // code to listen to changes on the server
      // When server sends new information, thread can update the list directly:
      // sensorList.clear();
      // sensorList.addAll(newList);
   }
}

Listener l = new Listener(sensorList);
Thread listenerThread = new Thread(l);
listenerThread.start();