try{

    ....

    } catch (error: InterruptedException) {
         emitter.tryOnError(BackupException(error.message ?: "unknown exception"))
    }