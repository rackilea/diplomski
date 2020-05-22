// ...

if (ActionContext.getContext() != null) {
  Map<String, Object> session = ActionContext.getContext().getSession();

  if (session != null && session.containsKey(I18nInterceptor.DEFAULT_SESSION_ATTRIBUTE)) {
    Locale locale = (Locale) session.get(I18nInterceptor.DEFAULT_SESSION_ATTRIBUTE);
  }
}

// ...