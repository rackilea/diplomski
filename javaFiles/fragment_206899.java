ImageIcon icon = ...
Class<? extends ImageIcon> clazz = icon.getClass();
Field urlField = clazz.getDeclaredField("location");
urlField.setAccessible(true);

URL location = (URL) urlField.get(icon);