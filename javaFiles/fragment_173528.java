chain.doFilter(myRequestWrapper, response);

            AsyncContext asyncContext = myRequestWrapper.getAsyncContext();
            asyncContext.addListener(new AsyncListener() {

                @Override
                public void onTimeout(AsyncEvent event) throws IOException 
                {
                            logger.log(Level.WARNING, "Async timeout...");
                }

                @Override
                public void onStartAsync(AsyncEvent event) throws IOException 
                {
                            logger.log(Level.INFO, "Async start...");
                }

                @Override
                public void onError(AsyncEvent event) throws IOException 
                {
                            logger.log(Level.SEVERE, "Async error...");
                }

                @Override
                public void onComplete(AsyncEvent event) throws IOException 
                {
                      HttpServletResponse httpResponse = (HttpServletResponse) event.getSuppliedResponse();
                     //HttpServletResponse httpResponse = (HttpServletResponse) event.getAsyncContext().getResponse();
                    if (httpResponse.getStatus() == HttpServletResponse.SC_OK || httpResponse.getStatus() == HttpServletResponse.SC_CREATED ) {
                                //some business logic
                    }
                }
    }, myRequestWrapper, httpServletResponse);