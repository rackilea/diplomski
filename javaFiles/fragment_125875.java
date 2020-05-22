@Override
 protected void reduce(Text key, Iterable values, Context context) throws IOException,InterruptedException {
      ...
      if(<condition to quit happen>){
          throw new QuitReducerException("Quitting reducer due to some specified reason");// You may add details of the reason you are quitting and this will be available in the job logs (in stderr)
      }
      ...
  }