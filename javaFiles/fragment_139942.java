if(!req.getUri().matches(websocketPath)){
    ctx.fireChannelRead(msg);
    return;
}

String [] splittedUri = req.getUri().split("\\?");
HashMap<String, String> params = new HashMap<String, String>();

if(splittedUri.length > 1){
    String queryString = splittedUri[1];
    for(String param : queryString.split("&")){
        String [] keyValue = param.split("=");
        if(keyValue != null && keyValue.length >= 2){
            logger.trace("key = {}, value = {}", keyValue[0], keyValue[1]);
            params.put(keyValue[0], keyValue[1]);
        }
    }
}

ctx.channel().attr(AttrKeys.getInstance().params()).set(params);