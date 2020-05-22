import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Version;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;
import org.hibernate.annotations.IndexColumn;

@Entity
public class Team implements Serializable {

    @Id @GeneratedValue private Long id;

    @Version private int version;

    @OneToMany(cascade=CascadeType.ALL, mappedBy="id.team")
    @IndexColumn(name="PLAYER_IDX")
    private List<Player> players = new ArrayList<Player>();

    private String name;

    protected Team() {}

    public Team(String name) {
        this.name = name;
    }

    public boolean addPlayer(Player player) {
        boolean result = players.add(player);
        if (result) {
            player.setPlayerId(new PlayerId(this, players.size() - 1));
        }
        return result;
    }

    public List<Player> getPlayers() {
        return players;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.SHORT_PREFIX_STYLE).append("name", name).append("players", players).toString();
    }
}