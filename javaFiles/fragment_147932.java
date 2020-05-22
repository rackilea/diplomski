class YourClassName{
    //Must be null
    //otherwise if you call onPreCreationGuildeCommand before creationGuilde
    //you would get error because variable hasn't been initialized
    private String nomGuilde = null;

    public static void creationGuilde(String[] args, Player player, String playerName){
        //set the value
        //value will persist outside the method because variable is global
        nomGuilde = args[2];
    }

    private void onPreCreationGuildeCommand(PlayerCommandPreprocessEvent event){
        // Here you can do anything with variable, for example:
        System.out.println(nomGuilde);
    }
}