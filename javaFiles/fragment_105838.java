private List<WayPoint> getWayPointListFromJsonString(String json) {
    List<WayPoint> wayPoints = new ArrayList<>();

    try {
        JSONObject jsonObject = new JSONObject(json);
        JSONArray wayPointJsonArray = jsonObject.getJSONObject("msg").getJSONArray("waypoints");
        for (int i = 0; i < wayPointJsonArray.length(); i++) {
            JSONObject wayPointJsonObject = wayPointJsonArray.getJSONObject(i);

            // Parse name
            String name = wayPointJsonObject.getString("name");

            // Parse pose to get position and orientation;
            JSONObject poseJsonObject = wayPointJsonObject.getJSONObject("pose");

            // Parse position form pose
            JSONObject positionJsonObject = poseJsonObject.getJSONObject("position");
            Position position = new Position();
            position.x = positionJsonObject.getDouble("x");
            position.y = positionJsonObject.getDouble("y");
            position.z = positionJsonObject.getDouble("z");

            // Parse orientation from pose.
            JSONObject orientationJsonObject = poseJsonObject.getJSONObject("orientation");
            Orientation orientation = new Orientation();
            orientation.x = orientationJsonObject.getDouble("x");
            orientation.y = orientationJsonObject.getDouble("y");
            orientation.z = orientationJsonObject.getDouble("z");
            orientation.w = orientationJsonObject.getDouble("w");

            Pose pose = new Pose();
            pose.position = position;
            pose.orientation = orientation;

            WayPoint wayPoint = new WayPoint();
            wayPoint.name = name;
            wayPoint.pose = pose;
            wayPoints.add(wayPoint);
        }
    } catch (JSONException e) {
        e.printStackTrace();
    }

    return wayPoints;
}