LinkedList<Point> objList = new LinkedList<Point>();
        LinkedList<Point> sceneList = new LinkedList<Point>();

        List<KeyPoint> keypoints_RefList = keypointsRef.toList();
        List<KeyPoint> keypoints_List = keypoints.toList();

        for (int i = 0; i < good_matches.size(); i++) {
            objList.addLast(keypoints_RefList.get(good_matches.get(i).queryIdx).pt);
            sceneList.addLast(keypoints_List.get(good_matches.get(i).trainIdx).pt);
        }                 

        MatOfPoint2f obj = new MatOfPoint2f();
        MatOfPoint2f scene = new MatOfPoint2f();

        obj.fromList(objList);  
        scene.fromList(sceneList);  

        Mat mask = new Mat();
        Mat hg = Calib3d.findHomography(obj, scene, 8, 10,  mask);