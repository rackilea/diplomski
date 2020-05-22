public Summary call(Summary s1, Summary s2) throws Exception {
    try {

        long grpCnt = s1.getDelta() - s2.getDelta();
        s.setDeltaSum(grpCnt);

    } catch (Exception e) {
        logger.error(" ==== error in INV_GET_GRP_SUM ==== :"+e);
        return new Summary();
    }
}