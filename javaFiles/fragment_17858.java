for (ModuleRegistration.ModulesHolderEntry entry : ModuleRegistration.getInstance()) {
    executor.submit(new Runnable () {
        public void run() {
            final Map<String, String> response = entry.getPlugin().process(outputs);
            // write to database
            System.out.println(response);
        }
    }
}