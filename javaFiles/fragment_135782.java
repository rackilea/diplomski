long temp = Long.parseLong(lineArray[2]);

try {
Feats.class.getField(lineArray[1]).set(lineArray[1], temp);;
} catch (NoSuchFieldException | SecurityException | IllegalArgumentException | IllegalAccessException e1) {
e1.printStackTrace();
}