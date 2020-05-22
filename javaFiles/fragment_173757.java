public static List<String> getMappingInfo(HandlerMethod method) {
        String prefixs[] = method.getBean().getClass().getAnnotation(RequestMapping.class).value();
        if (ArrayUtils.isEmpty(prefixs))
            prefixs = new String[] { "" };

        String mappings[] = method.getMethod().getAnnotation(RequestMapping.class).value();

        List<String> info = new ArrayList<>();
        for (String prefix : prefixs) {
            for (String mapping : mappings) {
                info.add(prefix + "/" + mapping);
            }
        }

        return info;
    }