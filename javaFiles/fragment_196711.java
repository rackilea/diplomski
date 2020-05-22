if (null == mstUser) {
  return MsgEnum.FG40010;
}   

if (!pwd.equals(pUtil.decrypt(mstUser.getPassword()))) {
    return MsgEnum.FG40010;
}