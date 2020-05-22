long nextActionAfterTick;
nextActionAfterTick = /* calculate the next tick */;

while(/* your loop */)
{
    if (nextActionAfterTick < this.clock.getTicks()) {
    {
        doYourAction();
        nextActionAfterTick = /* calculate the next tick */;
    }
}