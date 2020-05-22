PrintWriter out = new PrintWriter(new OutputStreamWriter(response.getOutputStream(), "UTF8"), true);
        for (int i = 0; i < result.length(); i++)
        {
            out.print(result.charAt(i));
        }

        out.flush();