public class GetAllAssetsResult
{
    @SerializedName("GetAllAssetsResult")
    public List<Asset> assets;

    class Asset
    {
        @SerializedName("ATCOCode")
        public String ATCOCode;

        @SerializedName("AssetID")
        public String AssetID;

        @SerializedName("Bearing")
        public String Bearing;

        @SerializedName("CommonName")
        public String CommonName;

        @SerializedName("Locality")
        public String Locality;

        @SerializedName("Location")
        public String Location;

        @SerializedName("SMSNumber")
        public String SMSNumber;

        @SerializedName("Street")
        public String Street;
    }
}