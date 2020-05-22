private static boolean restrictBy (String[] car, String make, String model, String type) {
    boolean filtered = true;
    if (make.length() > 0 && !car[0].equals(make))
    {
        filtered = false;
    }
    if (model.length() > 0 && !car[1].equals(model))
    {
        filtered = false;
    }
    if (type.length() > 0 && !car[2].equals(type))
    {
        filtered = false;
    }
    return filtered;
}