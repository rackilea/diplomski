String[] languages;
if( LG.contains("en")){
    languages = new String[] {"English"};
}else {
    languages = new String[] {"English/"+ Language,Language,"English"};
}
return languages;