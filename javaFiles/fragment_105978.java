import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.ScriptAssert;

@ScriptAssert(
    lang = "javascript",
    script = "!(_this.commRolesId.contains(4) && _this.gnrlTransportersId.isEmpty())",
    message = "errorMessage")
public class CommUserDto {
  @Size(min = 1, message = "should not be empty")
  private List<Long> commRolesId = new ArrayList<>();

  private List<Long> gnrlTransportersId = new ArrayList<>();

  public List<Long> getCommRolesId() {
    return commRolesId;
  }

  public void setCommRolesId(List<Long> commRolesId) {
    this.commRolesId = commRolesId;
  }

  public List<Long> getGnrlTransportersId() {
    return gnrlTransportersId;
  }

  public void setGnrlTransportersId(List<Long> gnrlTransportersId) {
    this.gnrlTransportersId = gnrlTransportersId;
  }
}