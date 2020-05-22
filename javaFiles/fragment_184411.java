if(condition) {
    new RegenerateToken().generate(DriverActivity.this, new Callback() {  
        @Override
        public void onResponse(String objects) { //your data do ur processing
        }
    });
}