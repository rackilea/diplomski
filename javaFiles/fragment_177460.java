public static class CodeData {
    public final ArrayList<S_Group> groups = new ArrayList<>();
    public final ArrayList<W_Code> codes = new ArrayList<>();
    public final ArrayList<S_Services> services = new ArrayList<>();
}

public CodeData getAllCodes()
{
    CodeData data = new CodeData();
    data.groups.addAll(skills.values());
    data.codes.addAll(codes.values());
    data.services.addAll(services.values());
    return data;
}