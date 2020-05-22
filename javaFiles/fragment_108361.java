final Iterator<Entry<String, String>> propsIterator = myLayoutProps.entrySet().iterator();
    while (propsIterator.hasNext()) {
        final Entry<String, String> entry = propsIterator.next();

        if (Validator.isNotNull(entry.getValue())) {
            StringUtil.replace(entry.getValue(), matchTarget, replaceTargetBy);

            sb.append(entry.getKey());
            sb.append(StringPool.EQUAL);
            sb.append(entry.getValue());
            sb.append(StringPool.NEW_LINE);
        }
        propsIterator.remove();
    }