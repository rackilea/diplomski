public void load(FMLInitializationEvent event){
        if(event.getSide() == Side.CLIENT)
        {
            RenderItem renderItem = Minecraft.getMinecraft().getRenderItem();
            renderItem.getItemModelMesher().register(testIngot, 0, new ModelResourceLocation(sekai.MODID + ":" + ((testItem) testIngot).getName(), "inventory"));
        }
    }