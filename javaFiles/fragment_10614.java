if (blockImg[x][y] != null) {
                 System.out.println("in is null: " + (in == null));
                 System.out.println("blocks[x][y] is null: "
                       + (blocks[x][y] == null));
                 System.out.println("isSolid is null: "
                       + (isSolid == null));
                 System.out.println("isSolid[x][y] is null: "
                       + (isSolid[x][y] == null));

                 if (in.intersects(blocks[x][y]) && isSolid[x][y] == true) {
                    {
                       return true;
                    }
                 }
              }