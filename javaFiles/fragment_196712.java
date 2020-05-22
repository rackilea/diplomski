public MsgEnum validateUser(String userId, String pwd, UserOperationEnum userOperatioEnum) {
    try {
        MstCredential mstUser = mstUserDAO.validateUser(userId);    

        if (isPasswordValid(mstUser, pwd)) {
            return MsgEnum.FG40010;
        }

        if (isOperationValid(mstUser, userOperatioEnum)) {
            return MsgEnum.FG20000;
        }

        return MsgEnum.FG50010;

    }
    catch(Exception e) {
        LOGGER.error("Error occured while validateStoreUser: "+e.getMessage(),e);
        MsgEnum.FG20020.setMsgDesc(MsgEnum.FG20020.getMsgDesc()+ e.getMessage());
        return MsgEnum.FG20020;
    }
}