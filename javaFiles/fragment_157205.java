package example.adapted;

import java.util.List;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlType;

import example.Channel;
import example.Wrapper;

@XmlRootElement(name="Output")
@XmlType(propOrder={"channels", "channelNames"})
public class AdaptedWrapper {

    private Wrapper wrapper = new Wrapper();
    private List<ChannelName> channelNames;

    @XmlTransient
    public Wrapper getWrapper() {
        for(ChannelName channelName : channelNames) {
            channelName.getChannel().setName(channelName.getName());
        }
        return wrapper;
    }

    @XmlElementWrapper(name="Wrapper")
    @XmlElement(name="Channel")
    public List<Channel> getChannels() {
        return wrapper.getChannels();
    }

    public void setChannels(List<Channel> channels) {
        wrapper.setChannels(channels);
    }

    @XmlElementWrapper(name="Wrapper")
    @XmlElement(name="ChannelName")
    public List<ChannelName> getChannelNames() {
        return channelNames;
    }

    public void setChannelNames(List<ChannelName> channelNames) {
        this.channelNames = channelNames;
    }

}