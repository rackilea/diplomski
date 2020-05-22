if(args.length > 0) {
   ...
   factory.initialize(args[0]);
} else {
   ...
   factory.initialize(App.class.getClassLoader().getResourceAsStream("quartz.properties"));
}