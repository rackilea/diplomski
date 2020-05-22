private static String expandCommandLine(final String cmd) {
        final Pattern vars = Pattern.compile("[$]\\{(\\S+)\\}");
        final Matcher m = vars.matcher(cmd);

        final StringBuffer sb = new StringBuffer(cmd.length());
        int lastMatchEnd = 0;
        while (m.find()) {
            sb.append(cmd.substring(lastMatchEnd, m.start()));
            final String envVar = m.group(1);
            final String envVal = System.getenv(envVar);
            if (envVal == null)
                sb.append(cmd.substring(m.start(), m.end()));
            else
                sb.append(envVal);
            lastMatchEnd = m.end();
        }
        sb.append(cmd.substring(lastMatchEnd));

        return sb.toString();
    }