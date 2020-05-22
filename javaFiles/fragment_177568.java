for (String value : yourMap.values()) {
    if (value.contains(subString)) {
        return true;
    }
}
return false;