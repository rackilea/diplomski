@XmlRootElement
public class GroupTotal {

    private String groupName;

    private double groupTotal;

    public GroupTotal(String groupName, double groupTotal) {
         this.groupName = groupName;
         this.groupTotal = groupTotal;
    }

    // getters and setters ...
}