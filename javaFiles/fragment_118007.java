public static class Map extends MapReduceBase implements
                Mapper<LongWritable, Text, Text, Text> {

            @Override
            public void map(LongWritable key, Text value,
                OutputCollector<Text, Text> output, Reporter reporter) {

                String url = value.toString();
                StringTokenizer urls = new StringTokenizer(url);
                Config.LoggerProvider = LoggerProvider.DISABLED;

            //setting countdownlatch to urls.countTokens() to block off that many threads.
            final CountDownLatch latch = new CountDownLatch(urls.countTokens());
            while (urls.hasMoreTokens()) {
                try {
                    word.set(urls.nextToken());
                    String currenturl = word.toString();
                    //create thread and fire for current URL here
                    thread = new URLProcessingThread(currentURL, latch);
                    thread.start();
                } catch (Exception e) {
                    e.printStackTrace();
                    continue;
                }

            }

          latch.await();//wait for 16 threads to complete execution
          //sleep here for sometime if you wish

        }

    }