Extension extOut = null;
for(Extension ext : leafletMap.getExtensions()){
    if(ext instanceof LLayers){
        extOut = ext;                
    }
}
leafletMap.removeControl((AbstractControl)extOut);