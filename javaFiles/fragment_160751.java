class StringContainer extends Container<String> {

    @Override   
    public void setItem(String item){           
        System.out.println( item.toUpperCase() ); 
        super.setItem( item );
    }
}