package com.example.examplemod;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.util.IIcon;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockMultiTextureDemo extends Block {

//Save state to NBT at the world save time.
private int state = 0;

private final int DONE = 0;
private final int WORKING = 1;
private final int NOPOWER = 2;
private final int MACHINEBROKE = 3;


@SideOnly(Side.CLIENT)
public static IIcon doneIcon;
@SideOnly(Side.CLIENT)
public static IIcon workIcon;
@SideOnly(Side.CLIENT)
public static IIcon nopowerIcon;
@SideOnly(Side.CLIENT)
public static IIcon brokeIcon;
@SideOnly(Side.CLIENT)
public static IIcon topIcon;

protected BlockMultiTextureDemo(Material material) {
    super(material);
}

@Override
public void registerBlockIcons(IIconRegister register) {
    super.registerBlockIcons(register);
    doneIcon = register.registerIcon("MODID:" + getUnlocalizedName()
            + "_DONE");
    workIcon = register.registerIcon("MODID:" + getUnlocalizedName()
            + "_WORKING");
    nopowerIcon = register.registerIcon("MODID:" + getUnlocalizedName()
            + "_NOPOWER");
    brokeIcon = register.registerIcon("MODID:" + getUnlocalizedName()
            + "_BROKE");
    topIcon = register.registerIcon("MODID:" + getUnlocalizedName()
            + "_TOP");

}

@Override
protected String getTextureName() {
    return super.getTextureName();
}

@Override
public IIcon getIcon(int side, int meta) {
    switch (meta) {
    case DONE:
        return doneIcon;
    case WORKING:
        return workIcon;
    case NOPOWER:
        return nopowerIcon;
    case MACHINEBROKE:
        return brokeIcon;
    default:
        return topIcon;
    }
  }
}