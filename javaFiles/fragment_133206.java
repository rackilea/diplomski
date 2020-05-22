Double min = Double.MAX_VALUE;

for (Measurement measure : measurements) {
    Double score = measure.map.get("score");
    if (score != null && score < min) {
        min = score;
    }
}

System.out.println(min);