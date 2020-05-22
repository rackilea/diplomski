@Override
    public synchronized Servlet loadServlet() throws ServletException {
        if (singleThreadModel) {
            Servlet instance;
            try {
                instance = existing.getClass().newInstance();
            } catch (InstantiationException e) {
                throw new ServletException(e);
            } catch (IllegalAccessException e) {
                throw new ServletException(e);
            }
            instance.init(facade);
            return instance;
        } else {
            if (!instanceInitialized) {
                existing.init(facade);
                instanceInitialized = true;
            }
            return existing;
        }
    }