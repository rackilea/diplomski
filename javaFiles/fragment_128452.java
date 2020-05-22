try {
    String token = BaseService.getBaseService().getToken();
    if(token == null){
        // recreate session here
    }
} catch (BaseServiceException e) {
    e.printStackTrace();
}