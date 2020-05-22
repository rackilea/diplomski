private void flipX(){


    emmiter.getAngle().setHigh(emmiter.getAngle().getHighMin(),emmiter.getAngle().getHighMax());
    emmiter.getAngle().setLow(emmiter.getAngle().getLowMin(),emmiter.getAngle().getLowMax());

    emmiter.getGravity().setHigh(emmiter.getGravity().getHighMin(),emmiter.getGravity().getHighMax());
    emmiter.getGravity().setLow(emmiter.getGravity().getLowMin(),emmiter.getGravity().getLowMax());

    emmiter.getWind().setHigh(-emmiter.getWind().getHighMin(),-emmiter.getWind().getHighMax());
    emmiter.getWind().setLow(-emmiter.getWind().getLowMin(),-emmiter.getWind().getLowMax());

    emmiter.getRotation().setHigh(-emmiter.getRotation().getHighMin(),-emmiter.getRotation().getHighMax());
    emmiter.getRotation().setLow(-emmiter.getRotation().getLowMin(),-emmiter.getRotation().getLowMax());

    emmiter.getYOffsetValue().setLow(emmiter.getYOffsetValue().getLowMin(),emmiter.getYOffsetValue().getLowMax());

    emmiter.getXOffsetValue().setLow(emmiter.getXOffsetValue().getLowMin(),emmiter.getXOffsetValue().getLowMax());

}