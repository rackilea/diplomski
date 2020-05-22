@Entity
@ApiModel
public class ServiceType {

    private String id;

    @ApiModelProperty(dataType = "java.lang.String")
    private Service service;
    private String type;

    public Service getService() {
        return service;
    }

    public void setService(Service service) {
        this.service = service;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}