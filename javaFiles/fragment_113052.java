@Embeddable
public class BridgeId implements Serializable
{
    public Integer student_id;

    public Integer course_id;

    public int hashCode() {
        return student_id + course_id;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) 
            return true;
        BridgeId b = (BridgeId)obj;
        if(b==null)
            return false;
        if (b.student_id == student_id && b.course_id == course_id) {
            return true;
        }
        return false;
    }
}