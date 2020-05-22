class Producer {
         ExecutorService executorService = 
          Executors.newFixedThreadPool(MAX_THREAD);
         //Read the CSV file line by line
         String line = "";
         int i = 0;
          while ((line = reader.readLine()) != null) {
             //create produver record
             ProducerRecord<String, String> csvProducerRecord = new ProducerRecord<>(topicName, key, line.trim());
             MessageSender sendMessage= new MessageSender(csvProducerRecord,producer);
            executorService.submit()...
          }
            }

        //Thread class          
        class MessageSender implements Runnable<>{
         MessageSender(Producerrecord,producer{
        //store in class level variable in thread class
        }
        public void run(){
            producer.send(csvProducerRecord...);
        }