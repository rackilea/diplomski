Iterator<AnimationObject> itr = animationObjects.iterator();

while (itr.hasNext()) {
            Iterator<SceneObject> itrMain = sceneObjects.iterator();
       //    ^
       //   reassigning itrMain each iteration of the outer loop

            AnimationObject object = itr.next();
            //Remove the word node from the animation object name so it matches main object name.
            String  tmpString = object.animationobjectName.replace("node-", "");
            System.out.println("Animation Object name is" +tmpString);
            while (itrMain.hasNext()) {
                SceneObject objectMain = itrMain.next();
                System.out.println("Scene Object name is" +objectMain.objectName);
                if (tmpString.equals(objectMain.objectName)) {
                    System.out.println("Animation Object matched to main object array" +tmpString);
                    objectMain.animations = object.animationData;
                    objectMain.hasAnimations = true;
                }
            }
        }