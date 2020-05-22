private long hitmarkerDrawStart;

if(collission) {
 hitmarkerDrawStart = TimeUtils.millis() + 1000; // 1000ms = 1s
}

public void render() {
 if(hitmarkerDrawStart > TimeUtils.millis()) {
//draw the hitmarker batch.draw(...)
}