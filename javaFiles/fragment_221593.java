interface World{
    public void onBreakEvent(BlockBreakEvent e);
}

class World1 extends BaseGame implements World{
    public void onBreakEvent(BlockBreakEvent e) {
        System.out.println("Breaking from world 1")
    }
}

class World2 extends BaseGame implements World{
    public void onBreakEvent(BlockBreakEvent  e) {
        System.out.println("Breaking from world 2")
    }
}