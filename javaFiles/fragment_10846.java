response.setContentType("application/json");
response.setCharacterEncoding("UTF-8");
        PrintWriter writer = null;
        try {
            writer = response.getWriter();
            writer.write(json);
        } finally {
            writer.close();
        }