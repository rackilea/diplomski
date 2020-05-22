while((line = br.readLine()) != null) {
        recordBatch.add(line);
        if(recordBatch.size() == 100){
            worker = new BatchRunnable(recordBatch);
            executor.execute(worker);
            recordBatch.clear();
        }

    }