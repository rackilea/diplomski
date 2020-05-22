try{
        doRun();
    }catch (RuntimeException e){
        logger.error("Uncaught Runtime Exception",e);
        return; // Keep working
    }catch (Throwable e){
        logger.error("Unrecoverable error",e);
        throw e;
    }