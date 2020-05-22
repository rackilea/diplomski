package com.badlydrawngames.wf.controllers;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputEvent.Type;

public class FloatingThumbpadController extends FixedThumbpadController {

    private Vector2 screenPos;
    private Vector2 localPos;
    private InputEvent fakeTouchDownEvent;

    public FloatingThumbpadController() {
        screenPos = new Vector2();
        localPos = new Vector2();
        fakeTouchDownEvent = new InputEvent();
        fakeTouchDownEvent.setType(Type.touchDown);
    }

    @Override
    public Vector2 getDirection() {
        if (Gdx.input.justTouched()) {
            // Get the touch point in screen coordinates.
            screenPos.set(Gdx.input.getX(), Gdx.input.getY());

            // Convert the touch point into local coordinates, place the touchpad and show it.
            localPos.set(screenPos);
            localPos = touchpad.getParent().screenToLocalCoordinates(localPos);
            touchpad.setPosition(localPos.x - touchpad.getWidth() / 2, localPos.y - touchpad.getHeight() / 2);
            touchpad.setVisible(true);

            // Fire a touch down event to get the touchpad working. 
            Vector2 stagePos = touchpad.getStage().screenToStageCoordinates(screenPos);
            fakeTouchDownEvent.setStageX(stagePos.x);
            fakeTouchDownEvent.setStageY(stagePos.y);
            touchpad.fire(fakeTouchDownEvent);
        }
        else if (!Gdx.input.isTouched()) {
            // The touch was just released, so hide the touchpad.
            touchpad.setVisible(false);
        }

        return super.getDirection();
    }
}