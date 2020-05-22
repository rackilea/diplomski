@Override
protected ShadowMap createShadowMap() {
    return new ShadowMap.Builder()
        .addShadowClass(OriginalMessenger.class, ShadowMessenger.class, true, true, true)
        .build();
}