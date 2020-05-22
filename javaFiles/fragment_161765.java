try {           requestCycle.request();

      log.warn("Response after request: "+webResponse.toString());

      if (requestCycle.wasHandled() == false) {
          requestCycle.setRequestTarget(new WebErrorCodeResponseTarget(
                  HttpServletResponse.SC_NOT_FOUND));             }           requestCycle.detach();

  } finally {             requestCycle.getResponse().close();         }       return