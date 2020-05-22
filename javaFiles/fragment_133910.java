import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;

import org.apache.commons.lang.builder.HashCodeBuilder;

@Embeddable
public class PlayerId implements Serializable {

    @ManyToOne
    private Team team;

    @Column(name="PLAYER_IDX", insertable=false, updatable=false)
    private int number;

    protected PlayerId() {}

    PlayerId(Team team, int number) {
        this.team = team;
        this.number = number;
    }

    public int getNumber() {
        return number;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        } else if (obj == this) {
            return true;
        } if (obj instanceof PlayerId) {
            PlayerId other = (PlayerId) obj;
            return other.team.equals(this.team) && other.number == this.number; 
        }
        return false;
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(team).append(number).toHashCode();
    }

}