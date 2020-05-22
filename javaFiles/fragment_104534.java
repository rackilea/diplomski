@Transactional(readOnly = false, 
      propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
      public void newUser(User user) throws Exception {
        try{
            userRepository.saveAndFlush(user);
         } catch(Exception e){
           throw new Exception("Unable to Save User Object ",e);
        }
     }