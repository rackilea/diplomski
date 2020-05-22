CompletionService service = new  ExecutorCompletionService(Executors.newFixedThreadPool(5));

    List<String> result = new ArrayList<String>();

    String readline = null;
    Callable<List<String>> sorter = null;
    String[] words = null;
    int noOfRunningFutures = 0;

     while ((readline = br.readLine()) != null) {
        words = readline.split(" ");
        List<String> input = Arrays.asList(words);
        sorter = new Sorter(input);

        service.submit(sorter);

        // add them to the number of futures which I am creating - to keep track of the Queue length
        noOfRunningFutures ++;
    }


    while (noOfRunningFutures > 0) 
    {
        try {

            // this is a blocking call - whenever there is a worker which is already completed
            // then it is fetched from the Queue                 
            Future<List<String>> completed = service.take();
            noOfRunningFutures --;

            // get the value from computed from the Future
            List<String> sorted =  completed.get();

            result.addAll(sorted);

            Collections.sort(result);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (ExecutionException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }