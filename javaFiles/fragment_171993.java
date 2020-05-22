private static String substitute(String text) {
        List<Macro> macros = getMacros();
        StringBuffer st = new StringBuffer(text);

        for (Macro macro : macros) {
            int start = st.indexOf(macro.getKey());
            if (start != -1) {
                st.replace(start, start + macro.getKey().length(), macro.getValue());
            }
        }
        return st.toString();
    }