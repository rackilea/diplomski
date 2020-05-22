...
} catch (Exception e) {
    if (e instanceof FileNotFoundException) {
        System.out.println("could not find the file...");
    } else {
        System.out.println("something else went wrong");
    }
}