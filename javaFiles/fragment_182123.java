ActiveXComponent iTunesCom = new ActiveXComponent("iTunes.Application");
Dispatch iTunesController = new Dispatch(iTunesCom.getObject());
IiTunes it = new IiTunes(iTunesController);
IITSourceCollection sourceList = it.getSources();
IITSource s = sourceList.getItem(1); // Index 1 is library source
IITPlaylistCollection pc = s.getPlaylists();
IITPlaylist p = pc.getItem(1); // Index 1 is library playlist
IITTrackCollection tracks = p.getTracks();
IITTrack track = tracks.getItemByName(songName);
track.play();