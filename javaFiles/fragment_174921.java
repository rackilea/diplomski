public class LineDetailsInfo{

        @JsonCreator
        public LineDetails( @JsonProperty("lineId") Long lineId, 
                            @JsonProperty("lineName") String lineName,
                            @JsonProperty("lineDescription") String lineDescription,
                            @JsonProperty("plant") String plant) {
            this.plant = plant;
            this.lineId = lineId;
            this.lineName = lineName;
            this.lineDescription = lineDescription;
        }
}