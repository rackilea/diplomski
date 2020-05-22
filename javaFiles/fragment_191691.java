public   class ItemA extends BaseItem {
    BigDecimal value;

    @Override
    public void postCalucate() {
        //some A specific calculations                        
        super.postCalucate();
    }
}