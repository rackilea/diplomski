public static Model [] findAllBySQL(String SQL){
    // find how many models do you have
    Model[] models = new Model[numberOfModels];
    for (Model model : models)
    {
         model = new Model();
         //do what you want with it...
    }
    return models; //sytax error here
}