public class UserInfoAdapter extends XmlAdapter<UserInfoFlattened, UserInfo>
{
    @Override
    public UserInfoFlattened marshal( UserInfo userInfo )
    {
        return new UserInfoFlattened( userInfo.getValue(), userInfo.getUserLevel().getId(), userInfo.getUserLevel().getName() );
    }

    // unmarshal analogous
}