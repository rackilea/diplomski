public class HeatMap{

private static List<JComponent> tiles = new ArrayList<JComponent>();    
private List<JComponent> heatmap = new ArrayList<JComponent>();
private Random rand = new Random();

static{
    tiles.add(new JLabel("Cold"));
    tiles.add(new JLabel("Hot"));
    tiles.add(new JLabel("Warm"));
}

public HeatMap(){
    for(int i=0; i<10000; i++){
        for(int j=0; j<400; j++){
                heatmap.add(tiles.get(rand.nextInt(3)));            
        }
    }
}
}