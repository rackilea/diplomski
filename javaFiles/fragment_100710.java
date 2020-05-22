case MotionEvent.ACTION_MOVE:
                onDrawViewListener.onMove(motionEvent); // added this line
                mDrawMoveHistory.get(mDrawMoveHistory.size() - 1).setEndX(motionEvent.getX()).setEndY(motionEvent.getY());

                if (mDrawingTool == DrawingTool.PEN || mDrawingMode == DrawingMode.ERASER) {
                    mDrawMoveHistory.get(mDrawMoveHistory.size() - 1).getDrawingPathList()
                            .get(mDrawMoveHistory.get(mDrawMoveHistory.size() - 1).getDrawingPathList().size() - 1)
                            .lineTo(motionEvent.getX(), motionEvent.getY());
                }
                invalidate();
                break;