public class FriendModel{
    String username;
    int proPic;
    int bckgImg;

    public FriendModel(){}

    //redundant constructor, you can remove this since you are using setter methods now.
    public FriendModel(String username, int proPic, int bckgImg){
        this.username=username;
        this.proPic=proPic;
        this.bckgImg=bckgImg;
    }

    //you'll need the below getters and setters..
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getProPic() {
        return proPic;
    }

    public void setProPic(int proPic) {
        this.proPic = proPic;
    }

    public int getBckgImg() {
        return bckgImg;
    }

    public void setBckgImg(int bckgImg) {
        this.bckgImg = bckgImg;
    }

}