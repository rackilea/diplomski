@SuppressWarnings("serial")
    SPI INSTANCE = (SPI) Native.loadLibrary("user32", SPI.class,
            new HashMap<String, Object>() {
                {
                    put(OPTION_TYPE_MAPPER, W32APITypeMapper.UNICODE);
                    put(OPTION_FUNCTION_MAPPER, W32APIFunctionMapper.UNICODE);
                }
            });