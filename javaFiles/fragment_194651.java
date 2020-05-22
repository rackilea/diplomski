for(BigDecimal bd : selectPriceList) {
    if(bd.compareTo(BigDecimal.ZERO) == 0) {
        return true;
    }
}
return false;