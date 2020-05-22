class MyClass{
    protected void doSomething(){

    }

    OnClickListener n = new OnClickListener(){
        public void onClick(View v){
            MyClass.this.doSomething();
        }
    };

}