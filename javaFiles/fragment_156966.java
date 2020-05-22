public void updateLocalDesc(){

    if(spnAssetType.getSelectedItem() != null){
          AssetType = spnAssetType.getSelectedItem().toString(); 
    } else {
        AssetType = " ";
    }

    if(spnAssetGroup.getSelectedItem() != null){
        AssetGroup = spnAssetGroup.getSelectedItem().toString();
    } else {
        AssetGroup = " ";
    }
   AssetType = spnAssetType.getSelectedItem().toString();     


       if(spnAssetSubGroup.getSelectedItem() != null && !spnAssetSubGroup.getSelectedItem().toString().equals("")){
           AssetSubGroup = spnAssetSubGroup.getSelectedItem().toString();
           tbLongDescription.setText(AssetType + "-" + AssetGroup + "-" + AssetSubGroup);
       } else
       {
           tbLongDescription.setText(AssetType + "-" + AssetGroup);
       }

}