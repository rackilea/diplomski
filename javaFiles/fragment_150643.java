public class Model {

    // I guess it should be List too -> List<Photos>
    // your response is not complete to see 
    Photos photos;


    public class Photos{
        int page;
        int pages;
        int perpage;
        int total;
        List<Photo> photo;


        //this photo class is inner class of Photos
        public class Photo{
            String id;
            String owner;
            String secret;
            //rest of things

        }
    }
}