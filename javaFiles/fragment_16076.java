FlowFile flowFile1 = session.create();
        final AtomicReference<FlowFile> holder = new AtomicReference<>(session.create());

        flowFile1 = session.write(flowFile1, new OutputStreamCallback() {
            @Override
            public void process(OutputStream out) throws IOException {

                FlowFile flowFile2 = session.write(holder.get(), new OutputStreamCallback() {
                    @Override
                    public void process(OutputStream out) throws IOException {

                    }
                });
                holder.set(flowFile2);

            }
        });