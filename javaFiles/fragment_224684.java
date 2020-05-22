for (int i = 0; i < argumentdetailsforRunner.length(); i++) {
    String key = argumentdetailsforRunner.get(i).getScriptArgumentName().toString();
    if (JsonargumentdetailsforRunner.contains(key)) {
        String argumentStringValue=JsonargumentdetailsforRunner.getString(key);
        log.info(argumentStringValue);
    }
}