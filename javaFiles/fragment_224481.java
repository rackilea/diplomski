private void populateWithCategories(List<Category> categories)
{
    for (int i = 0; i < categories.size(); i++)
    {
        Category category = categories.get(i);
        if (Categories.isKnown(category)
                && Categories.isValid(category))
                //&& Categories.hasAllowedGenders(category))
        {
            addService(category, i);
        }
    }

    new Handler().post(new Runnable(){

        @Override
        public void run(){
            pd.dismiss();
        }
    });
}