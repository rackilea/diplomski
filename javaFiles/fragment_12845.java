boolean retry = false;
do {
    try {
        runJob();
        retry = false;
    } catch (SpecificException e) { //timeout, network failure exceptions
        logger.error("Exception in running thread: "
            + this.getName() + ", restarting job");
        retry = true;
    }
} while(retry);