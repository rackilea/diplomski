headers.add(accessCtrl, url_to_host);
            headers.add(connect, keepAlive);
            headers.add(proxyConn, keepAlive);
            headers.add(contentType, request.getContentType());
            headers.add(kbn, kbnVerion);
            headers.add(cluster , cluster_key);
            request.setAttribute(presigned, false);
            headers.add(host, host);

            body=(body!=null && !body.equals(FieldNameConstant.BLANK) && "application/x-ndjson".equals(request.getContentType()))?body+"/n":body;