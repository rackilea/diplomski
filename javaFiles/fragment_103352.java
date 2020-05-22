try {
    String data = body;
    String[] args = data.split(" ");

    if(args.length > 3) {
        String latitude = args[1];
        String longitude = args[3];
    }
} catch(Exception ex) {
    // Handle exception here
}