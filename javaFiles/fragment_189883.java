try {
    ConnectionBuilder cb = new ConnectionBuilder().context(getApplicationContext()).url(YOUR_URL).parameter("parameterName",parameterValue).parameter("anotherParameter",itsValue).connect();
    result = cb.getResponse();
    } catch (Exception e){
        e.printStackTrace();
    }