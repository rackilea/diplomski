public class User implements Parcelable {

    private String userName;
    private String passWord;
    private boolean oldUser;

    public User(Parcel in) {
        userName = in.readString();
        passWord = in.readString();
        oldUser = in.readInt() == 1;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(userName);
        dest.writeString(passWord);
        dest.writeInt(oldUser ? 1 : 0);
    }

    public String getUserName() {
        return userName;
    }

    public String getPassWord() {
        return passWord;
    }

    public boolean getOldUser() {
        return oldUser;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public void setOldUser(boolean oldUser) {
        this.oldUser = oldUser;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Parcelable.Creator<User> CREATOR = new Parcelable.Creator<User>() {
        public User createFromParcel(Parcel in) {
            return new User(in);
        }

        public User[] newArray(int size) {
            return new User[size];
        }
    };    

}