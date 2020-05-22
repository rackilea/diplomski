DynamicsInfluencer di = effect.getControllers().get(i).findInfluencer(DynamicsInfluencer.class);
        DynamicsModifier dm;
        for (int j = 0; j < di.velocities.size; j++) {

            dm = (DynamicsModifier) di.velocities.get(j);

                ((PolarAcceleration) dm).phiValue.setHigh(90 - 0.5f * phiSpread, 90 + 0.5f * phiSpread);

                ((PolarAcceleration) dm).thetaValue.setHigh(angle - thetaSpread * 0.5f, angle + thetaSpread * 0.5f);
        }