public class ZoomToCursorViewInputHandler extends OrbitViewInputHandler
{
    public ZoomToCursorViewInputHandler()
    {
        ViewInputAttributes.ActionAttributes actionAttrs = this.getAttributes()
            .getActionMap(ViewInputAttributes.DEVICE_MOUSE_WHEEL)
            .getActionAttributes(ViewInputAttributes.VIEW_VERTICAL_TRANSLATE);
        actionAttrs.setMouseActionListener(new ZoomActionHandler());
    }

    protected class ZoomActionHandler extends VertTransMouseWheelActionListener
    {
        @Override
        public boolean inputActionPerformed(AbstractViewInputHandler inputHandler, MouseWheelEvent mouseWheelEvent,
            final ViewInputAttributes.ActionAttributes viewAction)
        {
            double zoomInput = mouseWheelEvent.getWheelRotation();
            Position position = wwd.getCurrentPosition();
            Point mouseControlPoint = mouseWheelEvent.getPoint();

            // Zoom toward the cursor if we're zooming in. Move straight out when zooming
            // out.
            if (zoomInput < 0 && position != null)
            {
                boolean res = super.inputActionPerformed(inputHandler, mouseWheelEvent, viewAction);

                BasicOrbitView view = (BasicOrbitView) getView();
                OrbitViewMoveToZoomAnimator zoomAnimator = (OrbitViewMoveToZoomAnimator) uiAnimControl.get(VIEW_ANIM_ZOOM);

                // for continuous scroll preserve the original target if mouse was not moved
                FixZoomPositionAnimator old = (FixZoomPositionAnimator) uiAnimControl.get(FixZoomPositionAnimator.VIEW_ANIM_KEY);
                if (old != null && old.getMouseControlPoint().equals(mouseControlPoint))
                {
                    position = old.getMouseGeoLocation();
                }
                FixZoomPositionAnimator fixZoomPositionAnimator = new FixZoomPositionAnimator(view, zoomAnimator, mouseControlPoint, position);
                fixZoomPositionAnimator.start();
                uiAnimControl.put(FixZoomPositionAnimator.VIEW_ANIM_KEY, fixZoomPositionAnimator);
                return res;
            }
            else
            {

                uiAnimControl.remove(FixZoomPositionAnimator.VIEW_ANIM_KEY); // when zoom direction changes we don't want to make position adjustments anymore
                return super.inputActionPerformed(inputHandler, mouseWheelEvent, viewAction);
            }
        }
    }

    // here goes aforementioned FixZoomPositionAnimator 

}