public void animateCard(BlackJackDrawCard card, int amountToMoveRight, int amountToMoveDown)
{
    TranslateAnimation animation = new TranslateAnimation(0, amountToMoveRight, 0, amounttoMoveDown);
    animation.setDuration(1000); // duration in millisec

    card.startAnimation(animation);
}