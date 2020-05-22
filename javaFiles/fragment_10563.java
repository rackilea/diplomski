for (int y = 0; y < totalY; y++) {
    string prev = ""; // this value doesn't equal anything you can see in the UI, so the first iteration of the loop works as expected 
    int cnt = 0;
    for (int x = 0; x < totalX - 1; x++) {
        string cur = fields[x][y].getText();
        if(cur.equals(prev)) {
            cnt ++;
        }
        else {
            if(cnt > 0) // skip the first empty line
              outFile.write(prev + "," + cnt + ",");
            prev = cur;
            cnt = 1;
        }
    }
    // write the last sequence
    outFile.write(prev + "," + cnt);
    outFile.newLine();
}