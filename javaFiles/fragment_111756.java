try {
        STRING_CHARS = String.class.getDeclaredField("value");
        STRING_CHARS.setAccessible(true);
    } catch (Exception e) {
        throw new RuntimeException(e);
    }