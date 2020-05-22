Pose startPose = startAnchor.getPose();
Pose endPose = hitResult.getHitPose();

// Clean up the anchor
session.removeAnchors(Collections.singleton(startAnchor));
startAnchor = null;

// Compute the difference vector between the two hit locations.
float dx = startPose.tx() - endPose.tx();
float dy = startPose.ty() - endPose.ty();
float dz = startPose.tz() - endPose.tz();

// Compute the straight-line distance.
float distanceMeters = (float) Math.sqrt(dx*dx + dy*dy + dz*dz);