ServletContext context = request.getSession().getServletContext();

ModuleConfig moduleConfig = ModuleUtils
                                .getInstance()
                                .getModuleConfig(request, context);

    MessageResourcesConfig[] msgConfigArr = ModuleUtils.getInstance()
                                            .getModuleConfig(request)
                                            .findMessageResourcesConfigs();

    MessageResources[] messages= new MessageResources[msgConfigArr.length]; 
for(int i = 0; i<msgConfigArr.length;i++){
    if(msgConfigArr[i]==null)
    continue;

    messages[i] = context.getAttribute(key[i] + moduleConfig.getPrefix());
}

    return messages;