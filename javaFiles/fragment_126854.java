...
public static final String MDC_COUNTRY = "com.y.foo.Country";
public void execute(JobExecutionContext context)
  /* Just guessing that you have the country in your JobContext. */
  MDC.put(MDC_COUNTRY, context.get(MDC_COUNTRY));
  try {
    /* Perform your job here. */
    ...
  } finally {
    MDC.remove(MDC_COUNTRY);
  }
}
...