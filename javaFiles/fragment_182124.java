ActiveXComponent iTunesCom = new ActiveXComponent("iTunes.Application");
Dispatch iTunesController = new Dispatch(iTunesCom.getObject());
IiTunes it = new IiTunes(iTunesController);
IITSourceCollection sourceList = it.getSources();
IITSource s = sourceList.getItem(1); // Index 1 is library source
IITPlaylistCollection pc = s.getPlaylists();
IITPlaylist playlist = pc.getItemByName(playlistName);
playlist.playFirstTrack();