// Define enumeration    
    public static enum LOCAL_COUNTER_MAP {
                INVALID 
            }   


        public void map(LongWritable Key, Text values, Context context)
                            throws IOException, InterruptedException {

                        try {
                                //Attempt process

                                context.write(HKey, HValue);

                            }
                        } catch (Exception e) {
                        // ignore value
                          context.getCounter(LOCAL_COUNTER_MAP.INVALID).increment(1);
                          return;
                        }
            }