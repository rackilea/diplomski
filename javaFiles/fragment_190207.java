import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonProperty;

public class SlaveEntity extends BaseEntity {
    private String ip;

    @JsonProperty("mac")
    private String macAddress;

    private String status;

    @OneToMany(mappedBy = "slave", targetEntity = PositionEntity.class, fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<PositionEntity> positions;

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getMacAddress() {
        return macAddress;
    }

    public void setMacAddress(String macAddress) {
        this.macAddress = macAddress;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<PositionEntity> getPositions() {
        return positions;
    }

    public void setPositions(List<PositionEntity> positions) {
        this.positions = positions;
    }

    @Override
    public String toString() {
        return String.format(
                "SlaveEntity [id=%d, ip=%s, mac=%s, status=%s, positions=%s]",
                getId(), ip, macAddress, status, positions);
    }
}