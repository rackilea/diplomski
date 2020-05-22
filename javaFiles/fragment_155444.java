switch (severity) {
    case DEBUG:
        // ignore
        break;
    case INFO:
        System.out.println(message);
        break;
    case WARN:
    case ERROR:
        System.err.println(message);
        break;
}