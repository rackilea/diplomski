LiveStreamRecorderMP4 recorder = new LiveStreamRecorderMP4();
 recorder.setRecordData(true);
 // Set to true if you want to version the previous file rather than overwrite it
 recorder.setVersionFile(true);
 // If recording only audio set this to false so the recording starts immediately
 recorder.setStartOnKeyFrame(true);
 boolean append = false;    
 //stream is a valid IMediaStream retrieved from Wowza API, outputPath a string 
 recorder.startRecording(stream, outputPath, append);