StreamingQuery query = lines
            .writeStream()
            .format("foreach")
            .foreach(new ForeachWriter<String>() {
                @Override
                public void process(String value) {
                    System.out.println("process() value = " + value);
                }

                @Override
                public void close(Throwable errorOrNull) {}

                @Override
                public boolean open(long partitionId, long version) {
                    return true;
                }
            })
            .start();