package example;

import java.util.ArrayList;
import java.util.List;

public class Wrapper {

    private List<Channel> channels = new ArrayList<Channel>();

    public List<Channel> getChannels() {
        return channels;
    }

    public void setChannels(List<Channel> channels) {
        this.channels = channels;
    }

}