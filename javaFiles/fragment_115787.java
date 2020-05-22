String fileName   = "path/to/my/file";
File file         = new File(fileName);
MediaInfo info    = new MediaInfo();
info.open(file);

String format     = info.get(MediaInfo.StreamKind.Video, i, "Format", 
                        MediaInfo.InfoKind.Text, MediaInfo.InfoKind.Name);
int bitRate       = info.get(MediaInfo.StreamKind.Video, i, "BitRate", 
                        MediaInfo.InfoKind.Text, MediaInfo.InfoKind.Name);
float frameRate   = info.get(MediaInfo.StreamKind.Video, i, "FrameRate", 
                        MediaInfo.InfoKind.Text, MediaInfo.InfoKind.Name);
short width       = info.get(MediaInfo.StreamKind.Video, i, "Width", 
                        MediaInfo.InfoKind.Text, MediaInfo.InfoKind.Name);

int audioBitrate  = info.get(MediaInfo.StreamKind.Audio, i, "BitRate", 
                        MediaInfo.InfoKind.Text, MediaInfo.InfoKind.Name);
int audioChannels = info.get(MediaInfo.StreamKind.Audio, i, "Channels", 
                        MediaInfo.InfoKind.Text, MediaInfo.InfoKind.Name);