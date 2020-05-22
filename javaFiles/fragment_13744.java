try {
    Class adapterClass = Class.forName(AdapterHolder.IMPL_CLASS_FQCN);
    sAdapterHolder = (AdapterHolder) adapterClass.newInstance();
} catch (Exception e) {
    if (sLogLevel.log(LogLevel.BASIC)) {
        Log.e(TAG, "Failed to initialize.", e);
    }
}