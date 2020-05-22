private Pose rajawaliPoseToJMEPoseCLOUD(com.projecttango.rajawali.Pose p) {
    Pose pose = new Pose(
        new Vector3f(
            (float)p.getPosition().x, 
            (float)p.getPosition().y, 
            (float)p.getPosition().z),
        new Quaternion(
            (float)p.getOrientation().x,
            (float)p.getOrientation().y,
            (float)p.getOrientation().z,
            (float)p.getOrientation().w
        ));

    return pose;
}