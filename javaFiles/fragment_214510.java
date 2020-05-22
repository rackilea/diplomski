@Root
public class Levels
{

@ElementList(type=Level.class, inline=true)
private List<Level> levels;

public Levels()
{

}

public Levels(@ElementList(name = "levels", type=Level.class, inline=true) List<Level> levels)
{
    this.levels = levels;
}


public List<Level> getLevels()
{
    return levels;
}

public void setLevels(List<Level> levels)
{
    this.levels = levels;
    }
}