public boolean equals(Object obj) {
    if (obj == null || "".equals(valueOf(obj))) {
      return true;
    }
    else if (isNumeric(obj)) {
      return "0".equals(valueOf(obj));
    }
    else if (obj instanceof Collection) {
      return ((Collection) obj).size() == 0;
    }
    else if (obj.getClass().isArray()) {
      return getLength(obj) == 0;
    }
    return false;
  }