IBlockState leverState = Blocks
                         .lever
                         .getDefaultState()
                         .withProperty(BlockLever.FACING,                  
                                       BlockLever.EnumOrientation.SOUTH
                                       );
  world.setBlockState(startPosition.offset(EnumFacing.SOUTH), leverState);