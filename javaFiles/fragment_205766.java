Map<String, String[]> map = request.getParameterMap();
for (Entry<String, String[]> entry : map.entrySet()) {
    String name = entry.getKey();
    String[] values = entry.getValue();
    logger.log(name + ": " + Arrays.toString(values));
}