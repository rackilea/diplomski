Exception ex = getReturnedException();
try {
    if (ex == null) {  //Did you mean equals null here?
        List<Map<String, Object>> tempResult = new ArrayList<>(result);        
        return tempResult;
    } else {
        throw ex;
    }
} finally {
    synchronizer.release();
}