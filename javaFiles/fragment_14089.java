private String exception = "";
@Override
    protected User doInBackground(List<Pair<String, String>>... params) {
        randomAPI api = randomAPI
                .getInstance(context);

        try {
            **thing that will generate error**
            }

        } catch (RandomException e) {
            Log.e(TAG, "Error", e);
            exception = e.getMessage();
        }
        return somethingThatIsUsableInOnPostExecute;
    }

    @Override
    protected void onPostExecute(User result) {
            if(!exception.isEmpty()){
                //exception path
            }
        }