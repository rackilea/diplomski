@Override
public void show() {
...
       for (StingEntity sting : stingList) {
            stage.addActor(sting);
        }

} //<- inserted

@Override
public void hide () {
...