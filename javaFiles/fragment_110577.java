import java.util.*;
public static final int BLOB_COUNT = 10;
List<Blob> blobs = new ArrayList<Blob>();

// this is our blob, the one that displays in the middle of the screen
Blob myBlob = new Blob(mouseX, mouseY, 50);

void setup() {
    size(1000, 500);
    for (int i = 0; i < BLOB_COUNT; i++){
        blobs.add(new Blob(random(displayWidth/2),random(displayHeight/2),50));
    }
}