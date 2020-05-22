public ArrayList<Photo> datedPhotos(String date1, String date2) {
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    ArrayList<Photo> photolist = new ArrayList<>();
    Date startDate, endDate;

    try {
        startDate = sdf.parse(date1);
        endDate = sdf.parse(date2);
        List<Photo> photos = new ArrayList<>();

        for (Photo pho : photos) {
            if (startDate.before(pho.getDate()) && endDate.after(pho.getDate())) {
                photolist.add(pho);
            }
        }
    } catch (ParseException e) {
        // Handle Exception accordingly
    }

    return photolist;
}