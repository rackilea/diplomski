ArrayList<String> starts = ReadFile.getFileStartingTime();
ArrayList<String> ends = ReadFile.getFileEndingTime();
ArrayList<String> subs = ReadFile.readSubtitles();

for(int i=0;i < ReadFile.maxLine();i++){ 
        data[i][1] = starts.get(i);
        data[i][2] = ends.get(i);
        data[i][3] = subs.get(i);
}