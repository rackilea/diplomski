public static void main(String args[]) {
    Gson gson = new Gson();
    String jsonstr ="{  \"type\": \"MultiPolygon\",\"coordinates\": [        [            [                [                    -71.25,                    42.33                ],                [                    -71.25,                    42.33                ]            ]        ],        [            [                [                    -71.23,                    42.33                ],                [                    -71.23,                    42.33                ]            ]        ]    ]}";
    JsonObjectBreakDown obj = gson.fromJson(jsonstr, JsonObjectBreakDown.class);

    System.out.println(Arrays.toString(obj.coordinates.get(0).get(0).get(0)));
}

public static class JsonObjectBreakDown {
    public String type; 
    public List<List<List<String[]>>> coordinates = new ArrayList<>();
    public void setCoordinates(List<List<List<String[]>>> coordinates) {
        this.coordinates = coordinates;
    }
}