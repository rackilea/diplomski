final Bounds bounds = pane.getBoundsInLocal();
                final boolean atRightBorder = ball.getLayoutX() + deltaX >= (bounds.getMaxX()-ball.getRadius());
                final boolean atLeftBorder = ball.getLayoutX() + deltaX <= (bounds.getMinX()+ball.getRadius());
                final boolean atBottomBorder = ball.getLayoutY() + deltaY >= (bounds.getMaxY()-ball.getRadius());
                final boolean atTopBorder = ball.getLayoutY() + deltaY <= (bounds.getMinY()+ball.getRadius());
                if(atRightBorder || atLeftBorder)
                    deltaX *= -1;
                if(atBottomBorder ||atTopBorder)
                    deltaY *= -1;

                ball.setLayoutX(ball.getLayoutX() + deltaX);
                ball.setLayoutY(ball.getLayoutY() + deltaY);

                // not sure what this line does, so you will need to put it where it makes sense:
                ball.Collision(deltaX, deltaY);