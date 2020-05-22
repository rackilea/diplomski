query2.getFirstInBackground(new GetCallback<ParseObject>() {
    @Override
    public void done(ParseObject parseObject, ParseException e) {
        if (parseObject == null) {
           //null means number is not registered
          // next step must be here if number not register dont return any value



        } else {
           //number is registerd so print toast here
        }
    }
});