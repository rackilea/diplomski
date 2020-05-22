if (HAS_PENDING_EXCEPTION) {
      ResourceMark rm(this);
      jio_fprintf(defaultStream::error_stream(),
            "\nException: %s thrown from the UncaughtExceptionHandler"
            " in thread \"%s\"\n",
            pending_exception()->klass()->external_name(),
            get_thread_name());
      CLEAR_PENDING_EXCEPTION;
    }