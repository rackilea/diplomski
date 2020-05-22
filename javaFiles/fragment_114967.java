Job job = new Job("Annotate"){
                protected IStatus run(IProgressMonitor monitor){
                    monitor.beginTask("Annotation..", annotate.getTotal());
                    ImplControlProgressDialog control = new ImplControlProgressDialog (monitor);
                    annotate.annotateData(control);
                    monitor.done();

                        Display.getDefault().asyncExec(new Runnable() {
                            public void run() {
                                try {
                                    SaveUtils.saveEntry(wizard.getEntry(), AnnotationEntry);
                                } catch (IOException e) {
                                    // TODO Auto-generated catch block
                                    e.printStackTrace();
                                }
                            }
                        });

                    return Status.OK_STATUS;
                }

            };
            job.setUser(true);
            job.schedule();