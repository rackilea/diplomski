...
  private static final String REQUESTHIDEADER = "Request-ID";
  private static final String REQUESTID = "REQUESTID";
  private static final String REQUESTSTARTTIME = "RSTARTTIME";

  @Override
  public ContainerRequest filter(final ContainerRequest request)
  {
    final String requestid = Long.toHexString(Double.doubleToLongBits(Math.random()));
    MDC.put(REQUESTID, requestid);
    MDC.put(REQUESTSTARTTIME, String.valueOf(System.currentTimeMillis()));
    if (LOGGER.isInfoEnabled())
    {
      LOGGER.info("Started: {} {} ({})", request.getMethod(), request.getPath(), requestid);
    }

    return request;
  }

  @Override
  public ContainerResponse filter(final ContainerRequest request, final ContainerResponse response)
  {
    try
    {
      final Long startTime = Long.parseLong(MDC.get(REQUESTSTARTTIME));
      final String rid = MDC.get(REQUESTID);
      final long duration = System.currentTimeMillis() - startTime;
      response.getHttpHeaders().add(REQUESTHIDEADER, rid);
      LOGGER.info("Finished: {} {} ({} ms)", request.getMethod(), request.getPath(), String.valueOf(duration));
    }
    catch (Exception e)
    {
      LOGGER.warn("Finished {} {}", request.getMethod(), request.getPath());
    }
    return response;
  }