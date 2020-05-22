@FacesConverter("roleEnumConverter")
public class RoleEnumConverter extends EnumConverter {

    public RoleEnumConverter() {
        super(Role.class);
    }

}