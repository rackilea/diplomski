// static private ArrayList seriesColors = new ArrayList();  <<<=== remove this line

public Audiogram(int widthParm, int heightParm) 
        throws Exception 
{ 
    super(widthParm, heightParm); 
    // seriesColors.add(new Color(0, 0, 255)); <<<=== remove this line

    // Set the default settings to an industrial audiogram 
    setType(INDUSTRIAL_AUDIOGRAM); 
}