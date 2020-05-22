if (reqUrl.endsWith(gzExt))
    {
        ForcableContentTypeWrapper newResponse = new ForcableContentTypeWrapper(response);
        newResponse.setHeader("Content-Encoding", "gzip");
        newResponse.forceContentType("text/javascript");
        filterChain.doFilter(request, newResponse);
        return;
    }