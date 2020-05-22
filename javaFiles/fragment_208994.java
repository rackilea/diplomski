try {
       session.connect();
} catch (JSchException e) {
       if ("Auth fail".equals(e.getMessage())) {
            isSuccess = false; //Auth fail
       }
}