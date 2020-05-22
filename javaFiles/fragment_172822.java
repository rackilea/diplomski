//calculate the gun position on top of the tank
gunPosX = tankPosX + gunPosOffsetX;
gunPosY = tankPosY + gunPosOffsetY;

//calculate the tank rotation center
tankRotationsCenterX = tankPosX + tankImage.getCenterOfRotationX();
tankRotationsCenterY = tankPosY + tankImage.getCenterOfRotationY();

//calculate distance between gun position and tank rotation center
dx = tankRotationsCenterX - gunPosX ;
dy = tankRotationsCenterY - gunPosY ;
dis = Math.sqrt(dx * dx + dy * dy);

//calculate the offset based on the rotation of the tank
//rotation offset for the gun placement
gunRotaOff = 20;

gunX_offset = dis*Math.cos(Math.toRadians(tankImage.getRotation()+gunRotaOff));
gunY_offset = dis*Math.sin(Math.toRadians(tankImage.getRotation()+gunRotaOff));

gunXhalf = gun.getImage().getWidth() / 2;
gunYhalf = gun.getImage().getHeight() / 2;

//draws the gun dependend on the ship position and the ship rotation
//don't forget to subtract half the width/height for exact positioning
gun.drawIngame(tankRotationsCenterX - gun_x_offset)-gunXhalf , (tankRotationsCenterY - gun_y_offset) - gunYhalf ));