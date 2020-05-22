Blob imageFor(String name, HttpServletResponse res) {
    // find desired image
    PersistenceManager pm = PMF.get().getPersistenceManager();
    Query query = pm.newQuery("select from MyImage " +
        "where name = nameParam " +
        "parameters String nameParam");
    List<MyImage> results = (List<MyImage>)query.execute(name);
    Blob image = results.iterator().next().getImage();

    // serve the first image
    res.setContentType("image/jpeg");
    res.getOutputStream().write(image.getBytes());
}