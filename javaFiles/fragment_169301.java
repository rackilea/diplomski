langService = iWorkspace.LanguageService();
    StringBuilder sb = new StringBuilder();
    sb.append("%let mysasvar=" + javalocalvar);
    ... more variables
    try {
        langService.Submit(sb.toString());
    } catch (GenericError e) {
        e.printStackTrace();
    }