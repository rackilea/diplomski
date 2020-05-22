Point topLeftRect = new Point(Math.min(zamboniCorner1.x,zamboniCorner2.x,zamboniCorner3.x,zamboniCorner4.x),
                              Math.min(zamboniCorner1.y,zamboniCorner2.y,zamboniCorner3.y,zamboniCorner4.y));

Point bottomRightRect = new Point(Math.max(zamboniCorner1.x,zamboniCorner2.x,zamboniCorner3.x,zamboniCorner4.x),
                                  Math.max(zamboniCorner1.y,zamboniCorner2.y,zamboniCorner3.y,zamboniCorner4.y));

Rectangle collisionDetectionRectangle =new Rectangle(topLeftRect,bottomRightRect);