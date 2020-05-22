class TrainArrival {

    public TrainArrival() {
    }

    @SerializedName("root")
    Root root;

    class Root {
        @SerializedName("@id")
        public int id;
    }
}