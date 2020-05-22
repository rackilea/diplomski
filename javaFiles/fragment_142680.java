public class TestScreenInput implements InputProcessor {

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        System.out.println("Touch down");
        character.jump();
        return true;
    }

    @Override
    ... //all other methods from InputProcessor
}