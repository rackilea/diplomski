@Override
public void setMinimumVoorraad(int minimumVoorraad) {

    try {
        Field field = this.getClass().getSuperclass().getDeclaredField("minimumVoorraad");
        field.setAccessible(true);

        if(minimumVoorraad <= 5)
            field.set(this, 6);
        else
            field.set(this, minimumVoorraad);

        field.setAccessible(false);
    }
    catch(NoSuchFieldException | IllegalAccessException e) {
        // do something
    }
}