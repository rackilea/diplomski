...
{
    ClickListener clickListener = new ClickListener(){
        @Override
        public void enter(InputEvent event, float x, float y, int pointer, Actor fromActor)
        {
           highlightButtons(fromActor);
        }
    }

    grid[i][j].addListener(clickListener);
}
...

public void highlightButtons(Actor actor)
{
    // iterate through the buttons and call setChecked of each button should be highlighted 
    // to detect right buttons you could use ArrayMap<ImageButton, YourClass>
}