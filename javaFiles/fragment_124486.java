try {

    Promise<Boolean> promiseActiveDirectoryCheck = ActiveDirectoryServices.authenticate(userName, password);
      return promiseActiveDirectoryCheck.flatMap(response -> {

      if(response){                           
        return Promise.pure(ok("access granted"));
      }


  });

}catch (AuthenticationException exp) {
  return Promise.pure(ok("access denied"));

}catch (CommunicationException exp) {
  return Promise.pure(ok("The active directory server is not reachable"));

}catch (NamingException exp) {
  return Promise.pure(ok("active directory domain name does not exist"));

}