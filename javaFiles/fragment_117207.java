@Override
protected void onDestroy() {
    super.onDestroy();
    if(isChangingConfigurations()){
        Toast.makeText(this,"got turned",Toast.LENGTH_SHORT).show();
    }else{
        Toast.makeText(this,"need to safe data",Toast.LENGTH_SHORT).show();
        //safe data
    }

}