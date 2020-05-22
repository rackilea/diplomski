public class CentroidGenerator {

    final Map<String, Centroid> centroids = new HashMap<String, Centroid>();

    public Collection<Centroid> getCentroids() {
        return centroids.values();
    }

    public void nextItem(FlickrDoc flickrDoc) {

        final String event = flickrDoc.getEvent();
        final Centroid existingCentroid = centroids.get(event);

        if (existingCentroid != null) {
            existingCentroid.update(flickrDoc);
        } else {
            final Centroid newCentroid = new Centroid(flickrDoc);
            centroids.put(event, newCentroid);
        }
    }


    public static void main(String[] args) throws IOException, SAXException {

        // instantiate Digester and disable XML validation
        [...]


        // now that rules and actions are configured, start the parsing process
        CentroidGenerator abp = (CentroidGenerator) digester.parse(new File("PjrE.data.xml"));

        Writer writer = null;

        try {
            File fileOutput = new File("centroids.xml");
            writer = new BufferedWriter(new FileWriter(fileOutput));
            writeOuput(writer, abp.getCentroids());

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (writer != null) {
                    writer.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    private static void writeOuput(Writer writer, Collection<Centroid> centroids) throws IOException {

        writer.append("<?xml version='1.0' encoding='utf-8'?>" + System.getProperty("line.separator"));
        writer.append("<collection>").append(System.getProperty("line.separator"));

        for (Centroid centroid : centroids) {
            writer.append("<doc>" + System.getProperty("line.separator"));

            writer.append("<title>" + System.getProperty("line.separator"));
            writer.append(centroid.getTitle());
            writer.append("</title>" + System.getProperty("line.separator"));

            writer.append("<description>" + System.getProperty("line.separator"));
            writer.append(centroid.getDescription());
            writer.append("</description>" + System.getProperty("line.separator"));

            writer.append("<time>" + System.getProperty("line.separator"));
            writer.append(centroid.getTime());
            writer.append("</time>" + System.getProperty("line.separator"));

            writer.append("<tags>" + System.getProperty("line.separator"));
            writer.append(centroid.getTags());
            writer.append("</tags>" + System.getProperty("line.separator"));

            writer.append("<geo>" + System.getProperty("line.separator"));

            writer.append("<lat>" + System.getProperty("line.separator"));
            writer.append(centroid.getLat());
            writer.append("</lat>" + System.getProperty("line.separator"));

            writer.append("<lng>" + System.getProperty("line.separator"));
            writer.append(centroid.getLng());
            writer.append("</lng>" + System.getProperty("line.separator"));

            writer.append("</geo>" + System.getProperty("line.separator"));

            writer.append("</doc>" + System.getProperty("line.separator"));

        }
        writer.append("</collection>" + System.getProperty("line.separator") + System.getProperty("line.separator"));

    }

    /**
     * JavaBean class that holds properties of each Document entry. It is important that this class be public and
     * static, in order for Digester to be able to instantiate it.
     */
    public static class FlickrDoc {
        private String id;
        private String title;
        private String description;
        private String time;
        private String tags;
        private String latitude;
        private String longitude;
        private String event;

        public void setId(String newId) {
            id = newId;
        }

        public String getId() {
            return id;
        }

        public void setTitle(String newTitle) {
            title = newTitle;
        }

        public String getTitle() {
            return title;
        }

        public void setDescription(String newDescription) {
            description = newDescription;
        }

        public String getDescription() {
            return description;
        }

        public void setTime(String newTime) {
            time = newTime;
        }

        public String getTime() {
            return time;
        }

        public void setTags(String newTags) {
            tags = newTags;
        }

        public String getTags() {
            return tags;
        }

        public void setLatitude(String newLatitude) {
            latitude = newLatitude;
        }

        public String getLatitude() {
            return latitude;
        }

        public void setLongitude(String newLongitude) {
            longitude = newLongitude;
        }

        public String getLongitude() {
            return longitude;
        }

        public void setEvent(String newEvent) {
            event = newEvent;
        }

        public String getEvent() {
            return event;
        }
    }

    public static class Centroid {
        private final String event;
        private String title;
        private String description;

        private String tags;

        private Integer time;
        private int nbTimeValues = 0; // needed to calculate the average later

        private Float latitude;
        private int nbLatitudeValues = 0; // needed to calculate the average later
        private Float longitude;
        private int nbLongitudeValues = 0; // needed to calculate the average later

        public Centroid(FlickrDoc flickrDoc) {
            event = flickrDoc.event;
            title = flickrDoc.title;
            description = flickrDoc.description;
            tags = flickrDoc.tags;
            if (flickrDoc.time != null) {
                time = Integer.valueOf(flickrDoc.time.trim());
                nbTimeValues = 1; // time is the sum of one value
            }            
            if (flickrDoc.latitude != null) {
                latitude = Float.valueOf(flickrDoc.latitude.trim());
                nbLatitudeValues = 1; // latitude is the sum of one value
            }
            if (flickrDoc.longitude != null) {
                longitude = Float.valueOf(flickrDoc.longitude.trim());
                nbLongitudeValues = 1; // longitude is the sum of one value
            }
        }

        public void update(FlickrDoc newData) {
            title = title + " " + newData.title;
            description = description + " " + newData.description;
            tags = tags + " " + newData.tags;
            if (newData.time != null) {
                nbTimeValues++;
                if (time == null) {
                    time = 0;
                }
                time += Integer.valueOf(newData.time.trim());
            }
            if (newData.latitude != null) {
                nbLatitudeValues++;
                if (latitude == null) {
                    latitude = 0F;
                }
                latitude += Float.valueOf(newData.latitude.trim());
            }
            if (newData.longitude != null) {
                nbLongitudeValues++;
                if (longitude == null) {
                    longitude = 0F;
                }
                longitude += Float.valueOf(newData.longitude.trim());
            }
        }

        public String getTitle() {
            return title;
        }

        public String getDescription() {
            return description;
        }

        public String getTime() {
            if (nbTimeValues == 0) {
                return null;
            } else {
                return Integer.toString(time / nbTimeValues);
            }
        }

        public String getTags() {
            return tags;
        }

        public String getLat() {
            if (nbLatitudeValues == 0) {
                return null;
            } else {
                return Float.toString(latitude / nbLatitudeValues);
            }
        }

        public String getLng() {
            if (nbLongitudeValues == 0) {
                return null;
            } else {
                return Float.toString(longitude / nbLongitudeValues);
            }
        }

        public String getEvent() {
            return event;
        }
    }
}