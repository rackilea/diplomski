public enum MyStateEnum {
    // Everything you had is fine

    // But now, add:
    public static MyStateEnum getMyStateByDesc(String desc) {
        for(MyStateEnum myState : MyStateEnum.values())
            if(myState.getDesc().equals(desc))
                return myState;

        return null;
    }

    @Override
    public String toString() {
        return getDesc();
    }
}