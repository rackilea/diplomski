public abstract class AbstractFamilyMember {

    @PathParam("grandfatherName")
    private String grandfatherName;

    @PathParam("fatherName")
    private String fatherName;

    @PathParam("sonName")
    private String sonName;

    ...
}