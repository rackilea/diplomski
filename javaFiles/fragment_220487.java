@SubscribeEvent
public void RenderVillageCheckerFromEvent(InputEvent.KeyInputEvent event)
{
    if (key_enable.isPressed())
    {
        ArrowMarker.arrowMarker.mode += 1;
        if (ArrowMarker.arrowMarker.mode == 4) {
            ArrowMarker.arrowMarker.mode = 0;
        }
    }
    if (key_h.isPressed()) {
        ArrowMarker.arrowMarker.Hactive = (ArrowMarker.arrowMarker.Hactive);
    }
    if (sen == -1.0F) {
        sen = mc.gameSettings.mouseSensitivity;
    }
    if (key_slow.getIsKeyPressed()) {
        mc.gameSettings.mouseSensitivity = (sen / 10.0F);
    } else {
        mc.gameSettings.mouseSensitivity = sen;
    }
    if ((mc.currentScreen != null) && (ArrowMarker.arrowMarker.mode > 2)) {
        ArrowMarker.arrowMarker.mode = 1;
    }
}