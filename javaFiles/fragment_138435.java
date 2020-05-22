@RequestMapping("/sendNotification")
    public HashMap<String, Object> sendNotification(@RequestBody SingleFieldPojo singleFieldPojo) {
        System.out.println("category: " + singleFieldPojo);

        if (!StringUtils.isEmpty(singleFieldPojo.getBrowserIdToken())) {
            MessagingFCM.sendMessageToDevice("Title", singleFieldPojo.getJobBoardId(), singleFieldPojo.getBrowserIdToken());
        }
        if (!StringUtils.isEmpty(singleFieldPojo.getPhoneIdToken())) {
            MessagingFCM.sendMessageToDevice("Title", singleFieldPojo.getJobBoardId(), singleFieldPojo.getPhoneIdToken());
        }

        // Run a task specified by a Supplier object asynchronously
        CompletableFuture<HashMap<String, Object>> future = CompletableFuture.supplyAsync(() -> {
            Optional<JobStatus> jobStatus = jobStatusRepo.findById(singleFieldPojo.getJobBoardId());
            HashMap<String, Object> output = new HashMap<>();
            if (jobStatus.isPresent()) {
                String status = jobStatus.get().getJobStatus();
                final CountDownLatch latch = new CountDownLatch(1);
                try {
                    do {
                        Optional<JobStatus> jobStatusNew = jobStatusRepo.findById(singleFieldPojo.getJobBoardId());
                        if(jobStatusNew.isPresent()) {
                            if(StringUtils.equals(status, "accept")) {
                                latch.countDown();
                            }
                        }
                        status = jobStatusNew.get().getJobStatus();
                        latch.await(2, TimeUnit.SECONDS);
                    } while (status.equals("accepted"));

                } catch (InterruptedException e) {
                    throw new IllegalStateException(e);
                }
            }
            return output;
        });

        // Block and get the result of the Future
        HashMap<String, Object> result = null;
        try {
            result = future.get(30, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (TimeoutException e) {
            e.printStackTrace();
        }
        HashMap<String, Object> output = new HashMap<>();
        output.put("success", jobStatusRepo.findById(singleFieldPojo.getJobBoardId()));
        return output;
    }