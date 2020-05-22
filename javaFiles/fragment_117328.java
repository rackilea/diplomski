net.minecraft.server.v1_12_R1.ItemStack stack = CraftItemStack.asNMSCopy(tnt);

NBTTagList tags = (NBTTagList) stack.getTag().get("CanPlaceOn");

if (tags == null)
    tags = new NBTTagList();

tags.add(new NBTTagString("minecraft:emerald_block"));

stack.getTag().set("CanPlaceOn", tags);

ItemStack toUse = CraftItemStack.asCraftMirror(stack);