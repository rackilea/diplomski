public class DayData {

@Attribute(name="dayName")
private String dayName;
@ElementList(name="subjectsData", inline=true)
public List<SubjectData> subjectsData = new ArrayList<SubjectData>();

public DayData(@Attribute(name="dayName") String dayName)
{
    this.dayName = dayName;
}

public String getDayName()
{
    return dayName;
}
}