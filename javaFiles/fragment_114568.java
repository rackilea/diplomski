public class EnumCombinations {

//Commenting out more than 4 items, loooong printout otherwise
public static enum ITEM{
    STICK(PlayerSlotPosition.SLOT_ONE),
    STONE(PlayerSlotPosition.SLOT_ONE),
    EGG(PlayerSlotPosition.SLOT_TWO),
    SHOVEL(PlayerSlotPosition.SLOT_TWO);
//      PAPER(PlayerSlotPosition.SLOT_THREE),
//      DIRT(PlayerSlotPosition.SLOT_THREE);
    //      DIRT(PlayerSlotPosition.SLOT_THREE);

    private ITEM(PlayerSlotPosition pos){

    }
}

public static enum PlayerSlotPosition{
    SLOT_THREE, SLOT_ONE, SLOT_TWO

}

public static List<List<ITEM>> getItemCombinations(List<ITEM> inventory){
    List<ITEM> prefix = new ArrayList<>();
    List<List<ITEM>> container = new ArrayList<>();
    List<ITEM> remainder; 

    if(inventory==null){
        System.out.println("Printing all item combinations, no inventory");
        remainder =  new ArrayList<>(Arrays.asList(ITEM.values()));
    }

    else {
        remainder = new ArrayList<>(inventory);
    }
    getItemCombinations(prefix, remainder, container);
    return container;
}

private static void getItemCombinations(List<ITEM> prefix, List<ITEM> remainder, List<List<ITEM>> container){
    int n=remainder.size();

    if(remainder.isEmpty()){
        container.add(prefix);
    }

    else {
        for(int i=0; i<n; i++) {
            List<ITEM> r = new ArrayList<>();
            List<ITEM> p = new ArrayList<>(prefix);
            p.add(remainder.get(i));
            for(int j=0; j<remainder.size(); j++){
                if(j==i)
                    continue;
                r.add(remainder.get(j));
            }
            getItemCombinations(p, r, container);
        }
    }
}

public static void main (String[] args) {
    System.out.println(getItemCombinations(null)+"\n");

    List<ITEM> playerINV = new ArrayList<>();
    playerINV.add(ITEM.STICK);
    playerINV.add(ITEM.STONE);
    playerINV.add(ITEM.EGG);
    System.out.println(getItemCombinations(playerINV));

}
}