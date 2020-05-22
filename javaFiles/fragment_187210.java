DestructorTheDestroyerOfWorlds.loadUp(correctAnswers);

boolean successfullyDestroyedAllAnswers = DestructorTheDestroyerOfWorlds.destroyAnswers(userAnswers);

if (successfullyDestroyedAllAnswers && DestructorTheDestroyerOfWorlds.isOutOfAmmo())
{
    System.out.println("Oh fateful user, thy answers were right!");
}
else
{
    System.out.println("Oh shameful user, thy answers were wrong!");
}