@Transactional
protected void process(Message amqpMessage, Channel channel)
            throws Exception {
   //getting event from message
   Long sessionId=5;
   Session mysession=sessionRepository.findOne(sessionId);
   mysession.setMyField("bla-bla");
   //And I get there unpredictable optimistic locking exception. 
   sessionRepository.save(mysession);
}