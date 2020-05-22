effect = Assets.assetManager.get(skillInfo.skillEffect, ParticleEffect.class).copy();

    for (int i = 0; i < effect.getControllers().size; i++) {

        effect.getControllers().get(i).attached = skillInfo.attached;

        if (skillInfo.attached && effect.getControllers().get(i).findInfluencer(DynamicsInfluencer.class) != null) {
            // Gdx.app.log("INFO", "FOUND DI");
            DynamicsInfluencer di = effect.getControllers().get(i).findInfluencer(DynamicsInfluencer.class);
            DynamicsModifier dm;
            for (int j = 0; j < di.velocities.size; j++) {

                dm = (DynamicsModifier) di.velocities.get(j);

                if (dm instanceof PolarAcceleration) {
                    // horizontal +/- spread
                    float phiSpread = Math.abs(((PolarAcceleration) dm).phiValue.getHighMax()
                            - ((PolarAcceleration) dm).phiValue.getHighMin());
                    ((PolarAcceleration) dm).phiValue.setHigh(90 - 0.5f * phiSpread, 90 + 0.5f * phiSpread);

                    // change to acc in opposite direction of movement
                    // direction
                    float angle = getAngleAroundY(direction);
                    float thetaSpread = Math.abs(((PolarAcceleration) dm).thetaValue.getHighMax()
                            - ((PolarAcceleration) dm).thetaValue.getHighMin());
                    ((PolarAcceleration) dm).thetaValue.setHigh(angle - thetaSpread * 0.5f, angle + thetaSpread * 0.5f); // rotation
                                                                                                                            // around
                                                                                                                            // y-axis

                } else {
                    // Gdx.app.log("INFO", "NO polar acc for: " +
                    // skillInfo.name);
                }
            }
        } else {
            // Gdx.app.log("INFO", "no DI");
        }