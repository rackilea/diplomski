@Override
    protected void onPostExecute(String resStr) {
        super.onPostExecute(resStr);
        delegate.handleResponse(resStr);
        if(isConnectTimeoutException){ 
           Toast.makeText(this.context, "Your connection timedout",Toast.LENGTH_LONG).show();
      }
    }