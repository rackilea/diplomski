batch.draw(cannonTextureRegion, 
                tank.getPosition().x - tank.getWidth() * 0.5f + 1f, 
                tank.getPosition().y - tank.getHeight() * 0.5f + 0.8667f,
                tank.getWidth() * 0.5f - 1f,                        // origin.x
                tank.getHeight() * 0.5f - 0.8667f,                  // origin.y
                6.8f, 2.06667f, 1, 1,                               // size & scale
                tank.cannon.getOwnAngle() * MathUtils.radiansToDegrees);