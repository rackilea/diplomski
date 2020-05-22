if (movedir > 0) {
                frame.setX(frame.getX() + actualSpeed);
                MyInputProcessor.dist -= actualSpeed;
                tweenManager.killAll();
                for (int i = 0; i < parts.size(); i++) {
                    Tween.to(circles[i], Accessor.POS_XY, delayValue[i])
                            .target(frame.getX() - frame.getRadius(), circles[i].getY()).start(tweenManager);
                }
            } else if (movedir < 0) {
                frame.setX(frame.getX() - actualSpeed);
                MyInputProcessor.dist += actualSpeed;
                tweenManager.killAll();
                for (int i = 0; i < parts.size(); i++) {
                    Tween.to(circles[i], Accessor.POS_XY, delayValue[i])
                            .target(frame.getX() - frame.getRadius(), 
             circles[i].getY()).start(tweenManager);

            }