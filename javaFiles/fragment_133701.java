handlePlayOnHover = (song) => {
    this.setState({
        showPlayOnHover: !this.state.showPlayOnHover,
        isPlaying: !this.state.isPlaying
    })
    this.handleSongClick(song)
}