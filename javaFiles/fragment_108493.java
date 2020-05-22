String errorMsg = "";
    if (x != null && y == null) {
        errorMsg = errorMsg.concat("Y cannot be blank<br>");
    }
    else if (x == null && y != null) {
        errorMsg = errorMsg.concat("X cannot be blank");
    }