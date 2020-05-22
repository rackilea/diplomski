@Transient
private String[] names;

@ElementList(inline=true)
@Path("names")
public List<String> getNamesAsList() {
    if (names == null)
        return null;
    else
        return Arrays.asList(names);
}