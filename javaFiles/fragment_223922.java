package forum12512299;

import java.util.List;
import javax.xml.bind.annotation.*;

@XmlRootElement
public class Struct {

    private List<String> members;

    @XmlAnyElement(MemberHandler.class)
    public List<String> getMembers() {
        return members;
    }

    public void setMembers(List<String> members) {
        this.members = members;
    }

}