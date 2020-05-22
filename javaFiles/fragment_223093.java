@Override
public int getItemViewType(int position) {
    if (messages.size() > 0 && messages.size() > 25 &&
        position == messages.size() - 1 && messages.get(position) == null){
        return FOOTER_TYPE;
    }else {
        Message message = messages.get(position);
        if (message.from_user.equals(AppSetting.getInstance().getUserData().user_id) && message.msg.contains("::FILE::")) {
            return FILE_TYPE;
        }else if (message.from_user.equals(AppSetting.getInstance().getUserData().user_id) && message.msg.contains("::FILE_DONE::")) {
            return FILE_DONE;
        }else if (message.to_user.equals(AppSetting.getInstance().getUserData().user_id) && message.msg.contains("::FILE_DONE::")) {
            return FILE_DONE_REP;
        }else if(message.from_user.equals(AppSetting.getInstance().getUserData().user_id)){
            return ME_TYPE;
        } else {
            return REP_TYPE;
        }
    }
}