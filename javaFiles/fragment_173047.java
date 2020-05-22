private class ParentClass {
    private String value;

    //... stuff ...

    private class Eventhandler implements ActionListener{
        double amount;

        public void actionPerformed(ActionEvent event){
            //... stuff ...

            ParentClass.this.value = Double.toString(amount);
        }
    }

    public void saying(){
        System.out.println(value);
    }
}