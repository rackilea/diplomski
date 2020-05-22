public boolean doesArrayContain(ArrayList<CarPart> parts, Class<? extends CarPart> type) {

    for (CarPart part : parts) {
        if (type.isInstance(part.getClass()))
            return true;
    }

    return false;
}