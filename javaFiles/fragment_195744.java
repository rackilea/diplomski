protected void process(Message amqpMessage, Channel channel)
            throws Exception {

   ServicesHelper.convertAndSend(<Consumer B token>,adaptSession().getId()));

}

@Transactional
protected Session adaptSession(){
   Session mysession=sessionRepository.findOne(5);
   mysession.setMyField("bla");
   sessionRepository.save(mysession);
   return mysession; 
}