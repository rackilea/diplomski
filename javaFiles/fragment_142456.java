MailTo mailTo = MailTo.parse(unsubscribeUrl);

        Map<String, String> headers = mailTo.getHeaders();
        Set<Map.Entry<String, String>> values = headers.entrySet();

        for (Map.Entry<String, String> header : values) {
            message.addHeader(header.getKey(), header.getValue());
        }