Collection<SkinMetadata> supportedSkins = SkinProvider.getSkinMetadata(context);
Iterator<SkinMetadata> iterator = supportedSkins.iterator();
while (iterator.hasNext()) {
    SkinMetadata next = iterator.next();
    skinFamily = next.getFamily();
    //etc.
}