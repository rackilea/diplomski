protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(resultCode == RESULT_OK || resultCode != RESULT_CANCELED){
              ClipData clipData = data.getClipData();
              if(clipData.getItemCount() > 3){
                   //notify user here...
              }
        }
}