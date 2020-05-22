public class JQueryArrayParameterRequestWrapper extends HttpServletRequestWrapper {
    public static final String BRACKETS_SUFFIX = "[]";

    private Map<String, String[]> _parameterMap;

    public JQueryArrayParameterRequestWrapper(HttpServletRequest request) {
        super(request);
    }

    @Override
    public Map<String, String[]> getParameterMap() {
        if (_parameterMap == null) {
            _parameterMap = modifyParameterMap(super.getParameterMap());
        }
        return _parameterMap;
    }

    @Override
    public Enumeration<String> getParameterNames() {
        return Collections.enumeration(getParameterMap().keySet());
    }

    @Override
    public String[] getParameterValues(String name) {
        return getParameterMap().get(name);
    }

    @Override
    public String getParameter(String name) {
        return getParameterValues(name) != null && getParameterValues(name).length > 0 ? getParameterValues(name)[0] : null;
    }

    private Map<String, String[]> modifyParameterMap(Map<String, String[]> oldParameterMap) {
        Map<String, String[]> newParameterMap = new HashMap<>(oldParameterMap.size());
        for (Map.Entry<String, String[]> entry : oldParameterMap.entrySet()) {
            String key = entry.getKey();
            if (key.endsWith(BRACKETS_SUFFIX)) {
                // remove brackets from parameter name
                String newKey = key.substring(0, key.length() - BRACKETS_SUFFIX.length());
                newParameterMap.put(newKey, entry.getValue());
            } else {
                // leave parameter unmodified
                newParameterMap.put(key, entry.getValue());
            }
        }
        return newParameterMap;
    }
}