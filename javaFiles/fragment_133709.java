public short[] getIds(String buttonId) {
    String[] idParts = anyId.split("-");
    return {Short.parseShort(idParts[0]), Short.parseShort(idParts[1]) ,Short.parseShort(idParts[2])};
}

short fieldIndex = getIds("1-1-1")[0];
short rowIndex = getIds("1-1-1")[1];
short columnIndex = getIds("1-1-1")[2];