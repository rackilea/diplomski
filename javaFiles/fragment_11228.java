final LinkedHashMap<String, String> parameterValues = new LinkedHashMap<>();
final BufferedReader reader = aRequest.getReader();
final String queryString = IOUtils.toString(reader);

final String[] parameterValuePairs = queryString.split("&");

for (String parameterValuePair : parameterValuePairs) {
    final String[] nameValueArray = parameterValuePair.split("=");
    parameterValues.put(nameValueArray[0], nameValueArray[1]);
}