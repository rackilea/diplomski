public void setPromotion(Promotion promotion) throws IllegalAccessException
{
    try {
        Field enclosingThisField = Image.class.getDeclaredField("this$0");
        enclosingThisField.setAccessible(true);
        enclosingThisField.set(this, promotion);
    }
    catch (NoSuchFieldException e) {}
}