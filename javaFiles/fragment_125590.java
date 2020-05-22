@Override
    public void onClick(AjaxRequestTarget aTarget)
    {
        String url = downloadBehavior.getCallbackUrl().toString();

        if (addAntiCache) {
            url = url + (url.contains("?") ? "&" : "?");
            url = url + "antiCache=" + System.currentTimeMillis();
        }

        // the timeout is needed to let Wicket release the channel
        aTarget.appendJavaScript("setTimeout(\"window.location.href='" + url + "'\", 100);");
    }