if (status == 0){ 
        imgStatus.setBackgroundResource(R.drawable.ic_on);
        editor.putInt("status", 1);
    }else{
        imgStatus.setBackgroundResource(R.drawable.icone_vermelho);
        editor.putInt("status", 0);            
    }
   editor.apply();
}