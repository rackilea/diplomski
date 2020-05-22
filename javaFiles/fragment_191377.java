public final String getSomething() {
   JSONObject obj = new JSONObject();
   Bean bean = .....;
   obj = JSONObject.fromObject(bean);
   return StringEscapeUtils.escapeHtml(obj.toString());
}