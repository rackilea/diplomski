RotationModifier yourModifier = new RotationModifier(3, 0, 360)
{
        @Override
        protected void onModifierStarted(IEntity pItem)
        {
                super.onModifierStarted(pItem);
                // Your action after starting modifier
        }

        @Override
        protected void onModifierFinished(IEntity pItem)
        {
                super.onModifierFinished(pItem);
                // Your action after finishing modifier
                //STOP ANIMATION HERE!!!
        }
};

yourEntity.registerEntityModifier(yourModifier);