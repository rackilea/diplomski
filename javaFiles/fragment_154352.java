public boolean isNumber() {
    try {
        return !Double.isNaN(Double.parseDouble(this.answer));
    } catch (Exception e) {
        logger.error("Not a Number");
        return false;
    }
}