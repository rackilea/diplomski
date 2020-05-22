for (int i = 0; i < futureList.size(); i++) {
        Future<Map<String, String>> future = futureList.get(i)
        try {
            Map<String, String> resultMap = future.get();

            for(String key : resultMap.keySet()) {
                System.out.println(resultMap.get(key));
            }
        } catch(ExecutionException ee) {
            System.out.println("Exception in task " + taskList.get(i).getId());
        }
    }